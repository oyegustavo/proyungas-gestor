package ar.org.proyungas.infrastructure.output.persistence.plantypehistory.get.byplantype;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.models.PlanTypeHistory;
import ar.org.proyungas.domain.output.plantypehistory.PlanTypeHistoryByPlanTypeFinderOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeHistoryEntity;
import ar.org.proyungas.infrastructure.output.persistence.plantype.create.PlanTypePersistenceMapper;
import ar.org.proyungas.infrastructure.output.persistence.plantypehistory.repository.PlanTypeHistoryRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PlanTypeHistoryByPlanTypeJpaOutputAdapter implements PlanTypeHistoryByPlanTypeFinderOutputPort{

    private final PlanTypeHistoryByPlanTypeFinderAdapterMapper mapper;
    private final PlanTypeHistoryRepository repository;
    private final PlanTypePersistenceMapper planTypeMapper;
	
	@Override
	public List<PlanTypeHistory> perform(PlanType planType) {
		
        log.info("Start perform PlanTypeHistoryByPlanTypeJpaOutputAdapter with enabled: {}", planType);
        
        try {
            List<PlanTypeHistoryEntity> entities = repository.findByPlanType(planTypeMapper.toEntity(planType));
            log.info("PlanTypeHistoryByPlanTypeJpaOutputAdapter performed successfully with plan type: {}", planType);
            return mapper.toDomain(entities);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing PlanTypeHistoryByPlanTypeJpaOutputAdapter with plan type: {}", planType, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
