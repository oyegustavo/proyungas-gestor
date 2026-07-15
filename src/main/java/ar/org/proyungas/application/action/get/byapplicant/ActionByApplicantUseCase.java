package ar.org.proyungas.application.action.get.byapplicant;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.output.action.ActionByApplicantOutputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ActionByApplicantUseCase implements ActionByApplicantFinder{

    private final ActionByApplicantMapper mapper;
    private final ActionByApplicantOutputPort outputPort;
	
	@Override
	public List<ActionByApplicantResult> perform(String applicantId, Integer page, Integer size) {
		log.info("Start performing ActionByApplicationUseCase with applicantId: {}", applicantId);
		return mapper.toResult(outputPort.perform(applicantId, page, size));
	}

}
