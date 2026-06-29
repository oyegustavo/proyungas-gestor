package ar.org.proyungas.infrastructure.output.persistence.plantype.get.byid;

import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.plantype.PlanTypeByIdFinderOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;
import ar.org.proyungas.infrastructure.output.persistence.repository.PlanTypeRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.PlanTypeNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PlanTypeByIdJpaOutputAdapter implements PlanTypeByIdFinderOutputPort{
	
    private final PlanTypeByIdFinderAdapterMapper mapper;
    private final PlanTypeRepository repository;

	@Override
	public PlanType perform(UUID id) {
        log.info("Start perform PlanTypeByIdJpaOutputAdapter with: {}", id);
        
        try {
            PlanTypeEntity entity = repository.findById(id).orElseThrow(
                    () -> new PlanTypeNotFoundException(ErrorCode.PLAN_TYPE_NOT_FOUND));
            log.info("PlanTypeByIdJpaOutputAdapter performed successfully with: {}", id);
            return mapper.toDomain(entity);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing PlanTypeByIdJpaOutputAdapter with: {}", id, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
