package ar.org.proyungas.infrastructure.output.persistence.plantype.get.byenabled;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.plantype.PlanTypeByEnabledFinderOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;
import ar.org.proyungas.infrastructure.output.persistence.repository.PlanTypeRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PlanTypeByEnabledJpaOutputAdapter implements PlanTypeByEnabledFinderOutputPort{

    private final PlanTypeByEnabledFinderAdapterMapper mapper;
    private final PlanTypeRepository repository;
	
	@Override
	public List<PlanType> perform(Boolean enabled) {
        log.info("Start perform PlanTypeByEnabledJpaOutputAdapter with enabled: {}", enabled);
        
        try {
            List<PlanTypeEntity> entities = repository.findByEnabledOrderByGroupAsc(enabled);
            log.info("PlanTypeByEnabledJpaOutputAdapter performed successfully with enabled: {}", enabled);
            return mapper.toDomain(entities);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing PlanTypeByIdJpaOutputAdapter with enabled: {}", enabled, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
}
