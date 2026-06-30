package ar.org.proyungas.application.plantype.get.byenabled;

import java.util.List;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.output.plantype.PlanTypeByEnabledFinderOutputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class PlanTypeGetByEnabledUseCase implements PlanTypeByEnabledFinder{
	
    private final PlanTypeGetByEnabledMapper mapper;
    private final PlanTypeByEnabledFinderOutputPort outputPort;
    
	@Override
	public List<PlanTypeByEnabledResult> perform(Boolean enabled) {
		log.info("Start performing ActionCreateUseCase with enabled: {}", enabled);
		return mapper.toResult(outputPort.perform(enabled));
	}
}
