package ar.org.proyungas.application.vectoriallayer.updatestatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.domain.output.action.VectorialLayerByIdFinderOutputPort;
import ar.org.proyungas.domain.output.action.VectorialLayerUpdateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.repository.VectorialLayerStatusConfigurationProperties;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.InvalidStatusProgressionException;
import ar.org.proyungas.shared.infrastructure.utils.CurrentUserUtils;
import ar.org.proyungas.shared.infrastructure.utils.UserInfo;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class VectorialLayerStatusUpdateUseCase implements VectorialLayerStatusUpdater {

    private final VectorialLayerByIdFinderOutputPort vectorialLayerByIdFinderOutputPort;
    private final VectorialLayerUpdateOutputPort outputPort;
    private final VectorialLayerStatusConfigurationProperties status;
    private final AuditLogOutputPort auditLogOutputPort;

    private Map<String, Set<String>> allowedTransitions;

    @PostConstruct
    private void initTransitions() {
        allowedTransitions = new HashMap<>();
        allowedTransitions.put(status.getPending(), Set.of(status.getWithoutPresenting()));
        allowedTransitions.put(status.getInRevision(), Set.of(status.getPending(), status.getToModify()));
        allowedTransitions.put(status.getObserved(), Set.of(status.getPending()));
        allowedTransitions.put(status.getOmmited(), Set.of(status.getWithoutPresenting()));
        allowedTransitions.put(status.getApproved(), Set.of(status.getInRevision()));
        allowedTransitions.put(status.getToModify(), Set.of(status.getApproved()));
    }

    @Override
    public void perform(VectorialLayerStatusUpdateCommand command, UUID id, HttpServletRequest request) {
        log.info("Start perform VectorialLayerStatusUpdateUseCase with request: {}", request);

        VectorialLayer vectorialLayer = vectorialLayerByIdFinderOutputPort.perform(id);
        String currentStatus = vectorialLayer.getCurrentStatus();
        String requestedStatus = command.getStatus();

        if (isTransitionAllowed(requestedStatus, currentStatus)) {
            outputPort.perform(vectorialLayer.withCurrentStatus(requestedStatus));
            log.info("Status updated from {} to {}", currentStatus, requestedStatus);
            
            AuditLog auditLog = AuditLog.builder()
                    .username(extractUserId(request))
                    .actionType("STATUS_UPDATE")
                    .entityType("VectorialLayer")
                    .entityId(vectorialLayer.getId())
                    .previousState(currentStatus)
                    .newState(requestedStatus)
                    .clientIp(request.getRemoteAddr())
                    .userAgent(request.getHeader("User-Agent"))
                    .build();

            auditLogOutputPort.perform(auditLog);
            
        } else {
            log.error("Invalid Status Progression: {} → {}", currentStatus, requestedStatus);
            throw new InvalidStatusProgressionException(ErrorCode.INVALID_STATUS_PROGRESSION_ERROR);
        }
    }

    private boolean isTransitionAllowed(String requested, String current) {
        return allowedTransitions.containsKey(requested) &&
               allowedTransitions.get(requested).contains(current);
    }
    
    private String extractUserId(HttpServletRequest request) {
    	UserInfo userInfo = CurrentUserUtils.getUserInfo(request);
        return userInfo.getUsername();
    }
}