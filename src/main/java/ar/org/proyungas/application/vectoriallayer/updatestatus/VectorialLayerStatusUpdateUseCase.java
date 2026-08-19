package ar.org.proyungas.application.vectoriallayer.updatestatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.models.EmailNotification;
import ar.org.proyungas.domain.models.LayerStatusHistory;
import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.domain.output.action.EmailNotificationOutputPort;
import ar.org.proyungas.domain.output.action.LayerStatusHistoryOutputPort;
import ar.org.proyungas.domain.output.action.VectorialLayerByIdFinderOutputPort;
import ar.org.proyungas.domain.output.action.VectorialLayerUpdateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.repository.VectorialLayerStatusConfigurationProperties;
import ar.org.proyungas.infrastructure.output.rest.email.EmailMessage;
import ar.org.proyungas.infrastructure.output.rest.email.EmailSenderOutputPort;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.InvalidStatusProgressionException;
import ar.org.proyungas.shared.infrastructure.utils.CurrentUserUtils;
import ar.org.proyungas.shared.infrastructure.utils.EmailTemplateType;
import ar.org.proyungas.shared.infrastructure.utils.JsonSerializerUtils;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
@Transactional
public class VectorialLayerStatusUpdateUseCase implements VectorialLayerStatusUpdater {

    private final VectorialLayerByIdFinderOutputPort vectorialLayerByIdFinderOutputPort;
    private final VectorialLayerUpdateOutputPort outputPort;
    private final VectorialLayerStatusConfigurationProperties status;
    private final JsonSerializerUtils jsonSerializerUtils;
    private final LayerStatusHistoryOutputPort layerStatusHistoryOutputPort;
    private final EmailNotificationOutputPort emailNotificationOutputPort;
    private final EmailSenderOutputPort emailSenderOutputPort;

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
    public void perform(VectorialLayerStatusUpdateCommand command, UUID vectorialLayerId, HttpServletRequest request) {
        log.info("Start VectorialLayerStatusUpdateUseCase with command: {}", command);

        VectorialLayer current = vectorialLayerByIdFinderOutputPort.perform(vectorialLayerId);
        String currentStatus = current.getCurrentStatus();
        String requestedStatus = command.getStatus();

        if (!isTransitionAllowed(requestedStatus, currentStatus)) {
            log.error("Invalid Status Progression: {} → {}", currentStatus, requestedStatus);
            throw new InvalidStatusProgressionException(ErrorCode.INVALID_STATUS_PROGRESSION_ERROR);
        }

        if (requestedStatus.equals(status.getOmmited()) && Boolean.TRUE.equals(current.getReinstatedFromOmitted())) {
            log.error("VectorialLayer {} cannot be omitted again", vectorialLayerId);
            throw new InvalidStatusProgressionException(ErrorCode.INVALID_STATUS_PROGRESSION_ERROR);
        }

        VectorialLayer updated = current.withCurrentStatus(requestedStatus);

        if (requestedStatus.equals(status.getOmmited()) && Boolean.FALSE.equals(current.getReinstatedFromOmitted())) {
            updated = updated.withReinstatedFromOmitted(true);
        }

        outputPort.perform(updated);
        log.info("Status updated from {} to {}", currentStatus, requestedStatus);
        
        auditStatusChange(current, updated, request);
        
        sendEmail(updated, currentStatus, requestedStatus);
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
    			.observation(updated.getObservation()) 
    			.userId(CurrentUserUtils.getUsername(request))
    			.build();

        layerStatusHistoryOutputPort.perform(layerStatusHistory);
    }
    
    private void sendEmail(VectorialLayer vectorialLayer, String currentStatus, String requestedStatus) {

        EmailTemplateType templateType = null;
        Map<String, Object> model = new HashMap<>();

        // Decide which template to use
        if (status.getInRevision().equals(currentStatus) && status.getObserved().equals(requestedStatus)) {
            templateType = EmailTemplateType.CAPA_OBSERVADA;
            model.put("applicant_name", vectorialLayer.getAction().getApplicant());
            model.put("layer_name", vectorialLayer.getTemplateLayer());
            model.put("action_number", vectorialLayer.getAction());
            model.put("comment_observation", vectorialLayer.getObservation());
            model.put("system_url", buildSystemUrl(vectorialLayer.getAction().getActionNumber()));
        } else if (status.getInRevision().equals(currentStatus) && status.getApproved().equals(requestedStatus)) {
            templateType = EmailTemplateType.CAPA_APROBADA;
            model.put("applicant_name", vectorialLayer.getAction().getApplicant());
            model.put("layer_name", vectorialLayer.getTemplateLayer());
            model.put("action_number", vectorialLayer.getAction());
            model.put("system_url", buildSystemUrl(vectorialLayer.getAction().getActionNumber()));
        } else if (status.getWithoutPresenting().equals(currentStatus) && status.getOmmited().equals(requestedStatus)) {
            templateType = EmailTemplateType.CAPA_OMITIDA;
            model.put("applicant_name", vectorialLayer.getAction().getApplicant());
            model.put("layer_name", vectorialLayer.getTemplateLayer());
            model.put("action_number", vectorialLayer.getAction());
            model.put("system_url", buildSystemUrl(vectorialLayer.getAction().getActionNumber()));
        } else if (status.getPending().equals(currentStatus) && status.getInRevision().equals(requestedStatus)) {
            templateType = EmailTemplateType.ACTUACION_PENDIENTE;
            model.put("applicant_name", vectorialLayer.getAction().getApplicant());
            model.put("action_number", vectorialLayer.getAction());
            model.put("plan_type", vectorialLayer.getAction().getPlanType());
        } else if (status.getApproved().equals(requestedStatus)) {
            templateType = EmailTemplateType.EXPEDIENTE_APROBADO;
            model.put("applicant_name", vectorialLayer.getAction().getApplicant());
            model.put("action_number", vectorialLayer.getAction());
            model.put("system_url", buildSystemUrl(vectorialLayer.getAction().getActionNumber()));
        } else if (status.getObserved().equals(currentStatus) && status.getPending().equals(requestedStatus)) {
            templateType = EmailTemplateType.RECARGA_CAPA;
            model.put("technician_name", vectorialLayer.getTechnicianAssigned());
            model.put("layer_name", vectorialLayer.getTemplateLayer());
            model.put("action_number", vectorialLayer.getAction());
            model.put("system_url", buildSystemUrl(vectorialLayer.getAction().getActionNumber()));
        }

        if (templateType != null) {
            EmailMessage emailMessage = EmailMessage.builder()
                    .to(vectorialLayer.getTechnicianAssigned()) // or technician email depending on template
                    .templateType(templateType)
                    .model(model)
                    .retries(3)
                    .build();

            emailSenderOutputPort.perform(emailMessage);
            auditEmail(vectorialLayer, emailMessage);
        } else {
            log.warn("No email template matched for transition {} → {}", currentStatus, requestedStatus);
        }
    }

    private String buildSystemUrl(String actionNumber) {
        return "https://sgv.chaco.gob.ar/actuacion/" + actionNumber;
    }

    
    private void auditEmail(VectorialLayer vectorialLayer, EmailMessage emailMessage) {
    	emailNotificationOutputPort.perform(
    			EmailNotification.builder()
    			.action(vectorialLayer.getAction())
    			.attempts(emailMessage.getRetries())
    			.eventType(emailMessage.getTemplateType().toString())
    			.layerTemplate(vectorialLayer.getTemplateLayer())
    			.recipient(vectorialLayer.getTechnicianAssigned())
    			.sentAt(LocalDateTime.now())
    			.statusSent(vectorialLayer.getCurrentStatus())
    			.build()
    			);
    }
}
