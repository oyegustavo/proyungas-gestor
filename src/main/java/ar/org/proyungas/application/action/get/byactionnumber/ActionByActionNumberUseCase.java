package ar.org.proyungas.application.action.get.byactionnumber;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.output.action.ActionByActionNumberOutputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ActionByActionNumberUseCase implements ActionByActionNumberFinder{

    private final ActionByActionNumberMapper mapper;
    private final ActionByActionNumberOutputPort outputPort;
	
	@Override
	public ActionByActionNumberResult perform(String actionNumber) {
		log.info("Start performing ActionByActionNumberUseCase with actionNumber: {}", actionNumber);
		return mapper.toResult(outputPort.perform(actionNumber));
	}

}
