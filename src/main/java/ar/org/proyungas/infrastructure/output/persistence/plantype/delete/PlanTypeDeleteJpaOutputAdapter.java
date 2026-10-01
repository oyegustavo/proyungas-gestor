package ar.org.proyungas.infrastructure.output.persistence.plantype.delete;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.plantype.PlanTypeDeleterOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.plantype.create.PlanTypePersistenceMapper;
import ar.org.proyungas.infrastructure.output.persistence.plantype.repository.PlanTypeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PlanTypeDeleteJpaOutputAdapter implements PlanTypeDeleterOutputPort{

    private final PlanTypeRepository repository;
    private final PlanTypePersistenceMapper mapper;
	
	@Override
	public void perform(PlanType planType) {
        log.info("Start perform PlanTypeDeleteJpaOutputAdapter with: {}", planType);
        repository.delete(mapper.toEntity(planType));
	}
}
