package ar.org.proyungas.application.vectoriallayer.updatestatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.models.LayerStatusHistory;
import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.domain.output.action.LayerStatusHistoryOutputPort;
import ar.org.proyungas.domain.output.action.VectorialLayerByIdFinderOutputPort;
import ar.org.proyungas.domain.output.action.VectorialLayerUpdateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.repository.VectorialLayerStatusConfigurationProperties;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.InvalidStatusProgressionException;
import ar.org.proyungas.shared.infrastructure.utils.CurrentUserUtils;
import ar.org.proyungas.shared.infrastructure.utils.JsonSerializerUtils;
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
    private final JsonSerializerUtils jsonSerializerUtils;
    private final LayerStatusHistoryOutputPort layerStatusHistoryOutputPort;

    private Map<String, Set<String>> allowedTransitions;

    @PostConstruct
    private void initTransitions() {
        allowedTransitions = Map.of(
            status.getPending(), Set.of(status.getWithoutPresenting()),
            status.getInRevision(), Set.of(status.getPending(), status.getToModify()),
            status.getObserved(), Set.of(status.getPending()),
            status.getOmmited(), Set.of(status.getWithoutPresenting()),
            status.getApproved(), Set.of(status.getInRevision()),
            status.getToModify(), Set.of(status.getApproved())
        );
    }

    @Override
    public void perform(VectorialLayerStatusUpdateCommand command, UUID id, HttpServletRequest request) {
        log.info("Start VectorialLayerStatusUpdateUseCase with command: {}", command);

        VectorialLayer current = vectorialLayerByIdFinderOutputPort.perform(id);
        String currentStatus = current.getCurrentStatus();
        String requestedStatus = command.getStatus();

        if (!isTransitionAllowed(requestedStatus, currentStatus)) {
            log.error("Invalid Status Progression: {} → {}", currentStatus, requestedStatus);
            throw new InvalidStatusProgressionException(ErrorCode.INVALID_STATUS_PROGRESSION_ERROR);
        }

        if (requestedStatus.equals(status.getOmmited()) && Boolean.TRUE.equals(current.getReinstatedFromOmitted())) {
            log.error("VectorialLayer {} cannot be omitted again", id);
            throw new InvalidStatusProgressionException(ErrorCode.INVALID_STATUS_PROGRESSION_ERROR);
        }

        VectorialLayer updated = current.withCurrentStatus(requestedStatus);

        if (requestedStatus.equals(status.getOmmited()) && Boolean.FALSE.equals(current.getReinstatedFromOmitted())) {
            updated = updated.withReinstatedFromOmitted(true);
        }

        outputPort.perform(updated);
        log.info("Status updated from {} to {}", currentStatus, requestedStatus);

        auditStatusChange(current, updated, request);
    }

    private boolean isTransitionAllowed(String requested, String current) {
        return allowedTransitions.getOrDefault(requested, Set.of()).contains(current);
    }

    private void auditStatusChange(VectorialLayer previous, VectorialLayer updated, HttpServletRequest request) {
    	LayerStatusHistory layerStatusHistory = LayerStatusHistory.builder()
    			.action("STATUS_UPDATE")
    			.layerTemplate(updated.getTemplateLayer())
    			.layerVersion(updated.getCurrentVersion())
    			.previousState(jsonSerializerUtils.toJson(previous))
    			.newState(jsonSerializerUtils.toJson(updated))
    			.observation(null) //TODO: what's this
    			.userId(CurrentUserUtils.getUsername(request))
    			.build();

        layerStatusHistoryOutputPort.perform(layerStatusHistory);
    }
}
