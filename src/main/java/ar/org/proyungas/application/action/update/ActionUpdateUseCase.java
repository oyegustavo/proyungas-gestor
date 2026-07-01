package ar.org.proyungas.application.action.update;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionByActionNumberOutputPort;
import ar.org.proyungas.domain.output.action.ActionUpdateOutputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ActionUpdateUseCase implements ActionUpdater{

    private final ActionUpdateOutputPort actionUpdateOutputPort;
    private final ActionByActionNumberOutputPort actionByActionNumberFinderOutputPort;
	
	@Override
	public void perform(ActionUpdateCommand command, String actionNumber) {
        log.info("Start performing ActionUpdateUseCase with data: {}", command);
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
