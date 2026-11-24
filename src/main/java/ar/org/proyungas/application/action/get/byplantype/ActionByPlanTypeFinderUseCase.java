package ar.org.proyungas.application.action.get.byplantype;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.output.action.ActionByPlanTypeOutputPort;
import ar.org.proyungas.domain.output.plantype.PlanTypeByIdFinderOutputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class ActionByPlanTypeFinderUseCase implements ActionByPlanTypeFinder{

    private final ActionByPlanTypeMapper mapper;
    private final ActionByPlanTypeOutputPort outputPort;
    private final PlanTypeByIdFinderOutputPort planTypeByIdFinderOutputPort;
	
	@Override
	public List<ActionByPlanTypeFinderResult> perform(UUID id) {
		log.info("Start performing ActionByPlanTypeFinderUseCase with planType: {}", id);
		return mapper.toResult(outputPort.perform(planTypeByIdFinderOutputPort.perform(id)));
	}

}
