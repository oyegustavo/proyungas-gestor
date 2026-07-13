package ar.org.proyungas.application.action.update;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionByActionNumberOutputPort;
import ar.org.proyungas.domain.output.action.ActionUpdateOutputPort;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.ForbiddenActionApplicantException;
import ar.org.proyungas.shared.infrastructure.utils.CurrentUserUtils;
import ar.org.proyungas.shared.infrastructure.utils.UserInfo;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ActionUpdateUseCase implements ActionUpdater{

    private final ActionUpdateOutputPort actionUpdateOutputPort;
    private final ActionByActionNumberOutputPort actionByActionNumberFinderOutputPort;
	
	@Override
	public void perform(ActionUpdateCommand command, String actionNumber, HttpServletRequest requests) {
        log.info("Start performing ActionUpdateUseCase with data: {}", command);
        UserInfo userInfo = CurrentUserUtils.getUserInfo(requests);
        if (!userInfo.getUsername().equals(command.getApplicantId())) {
			log.error("ERROR - this action belong to another applicant");
			throw new ForbiddenActionApplicantException(ErrorCode.FORBIDDEN_ACTION_APPLICANT);
		}
        
        Action existingAction = actionByActionNumberFinderOutputPort.perform(actionNumber);
        actionUpdateOutputPort.perform(buildAction(command, existingAction));
	}
	
	private Action buildAction(ActionUpdateCommand command, Action existingAction) {
	    return existingAction
	        .withApplicantId(command.getApplicantId())
	        .withDerivativeStatus(command.getDerivativeStatus())
	        .withUploadedById(command.getUploadedById());
	}
}
