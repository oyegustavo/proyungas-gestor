package ar.org.proyungas.application.action.update;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.output.action.ActionByActionNumberOutputPort;
import ar.org.proyungas.domain.output.action.ActionUpdateOutputPort;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.ForbiddenActionApplicantException;
import ar.org.proyungas.shared.infrastructure.utils.CurrentUserUtils;
import ar.org.proyungas.shared.infrastructure.utils.JsonSerializerUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ActionUpdateUseCase implements ActionUpdater{

    private final ActionUpdateOutputPort actionUpdateOutputPort;
    private final ActionByActionNumberOutputPort actionByActionNumberFinderOutputPort;
    private final AuditLogOutputPort auditLogOutputPort;
    private final JsonSerializerUtils jsonSerializerUtils;
	
	@Override
	public void perform(ActionUpdateCommand command, String actionNumber, HttpServletRequest request) {
        log.info("Start performing ActionUpdateUseCase with data: {}", command);
        if (!CurrentUserUtils.getUsername(request).equals(command.getApplicantId())) {
			log.error("ERROR - this action belong to another applicant");
			throw new ForbiddenActionApplicantException(ErrorCode.FORBIDDEN_ACTION_APPLICANT);
		}
        
        Action existingAction = actionByActionNumberFinderOutputPort.perform(actionNumber);
        Action updatedAction = buildAction(command, existingAction);
        
        actionUpdateOutputPort.perform(buildAction(command, existingAction));
        
        String previousJson = jsonSerializerUtils.toJson(existingAction);
        String newJson = jsonSerializerUtils.toJson(updatedAction);
        
        AuditLog auditLog = AuditLog.builder()
                .username(CurrentUserUtils.getUsername(request))
                .actionType("UPDATE")
                .entityType("Action")
                .entityId(existingAction.getId())
                .previousState(previousJson)
                .newState(newJson)
                .clientIp(request.getRemoteAddr())
                .userAgent(request.getHeader("User-Agent"))
                .build();

        auditLogOutputPort.perform(auditLog);
	}
	
	private Action buildAction(ActionUpdateCommand command, Action existingAction) {
	    return existingAction
	        .withApplicant(command.getApplicantId())
	        .withDerivativeStatus(command.getDerivativeStatus())
	        .withUploadedById(command.getUploadedById());
	}
}
