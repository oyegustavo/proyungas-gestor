package ar.org.proyungas.infrastructure.output.persistence.plantype.create;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.plantype.PlanTypeCreateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.plantype.repository.PlanTypeRepository;
import ar.org.proyungas.shared.infrastructure.input.ActionBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PlanTypeCreateJpaPersistenceAdapter implements PlanTypeCreateOutputPort{

    private final PlanTypePersistenceMapper mapper;
    private final PlanTypeRepository repository;
	
	@Override
	public PlanType perform(PlanType planType) {
        log.info("Starting perform PlanTypeCreateJpaPersistenceAdapter with data: {}", planType);
        try {
        	
        	return mapper.toDomain(repository.save(mapper.toEntity(planType)));

        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing PlanTypeCreateJpaPersistenceAdapter with data {}", planType, e);
            throw new ActionBadRequestException(ErrorCode.INVALID_ACTION_ERROR);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing ActionSaveJpaPersistenceAdapter with data {}", planType, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
