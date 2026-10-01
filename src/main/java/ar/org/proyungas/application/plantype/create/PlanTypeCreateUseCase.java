package ar.org.proyungas.application.plantype.create;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.output.plantype.PlanTypeCreateOutputPort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class PlanTypeCreateUseCase implements PlanTypeCreator{

    private final PlanTypeCreateMapper mapper;
    private final PlanTypeCreateOutputPort outputPort;
	
	@Override
	public PlanTypeCreateResult perform(PlanTypeCreateCommand command) {
        log.info("Starting perform PlanTypeCreateUseCase with data: {}", command);
        return mapper.toResult(outputPort.perform(mapper.toDomain(command)));
	}
}
