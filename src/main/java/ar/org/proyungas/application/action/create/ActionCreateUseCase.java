package ar.org.proyungas.application.action.create;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.output.action.ActionSaveOutputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ActionCreateUseCase implements ActionCreator{
	
    private final ActionCreateMapper mapper;
    private final ActionSaveOutputPort outputPort;

	@Override
	public ActionCreateResult perform(ActionCreateCommand command) {
        log.info("Start performing ActionCreateUseCase with data: {}", command);
        return mapper.toResult(outputPort.perform(mapper.toDomain(command)));
	}

}
