package ar.org.proyungas.application.plantypehistory.get.byplantype;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.org.proyungas.application.layertemplate.create.PlanTypeCommand;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.models.PlanTypeHistory;
import ar.org.proyungas.domain.output.plantype.PlanTypeByIdFinderOutputPort;
import ar.org.proyungas.domain.output.plantypehistory.PlanTypeHistoryByPlanTypeFinderOutputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class PlanTypeHistoryGetByPlanTypeUseCase implements PlanTypeHistoryByPlanTypeFinder{
	
	private final PlanTypeHistoryGetByPlanTypeMapper mapper;
	private final PlanTypeByIdFinderOutputPort planTypeByIdFinderOutputPort;
	private final PlanTypeHistoryByPlanTypeFinderOutputPort planTypeHistoryByPlanTypeFinderOutputPort;
	
	@Override
	public List<PlanTypeHistoryByPlanTypeResult> perform(PlanTypeCommand command) {
		log.info("Start performing PlanTypeHistoryGetByPlanTypeUseCase with command: {}", command);
		PlanType planType = planTypeByIdFinderOutputPort.perform(command.getId());
		List<PlanTypeHistory> planTypeHistories = planTypeHistoryByPlanTypeFinderOutputPort.perform(planType);
		return mapper.toResult(planTypeHistories);
	}

}
