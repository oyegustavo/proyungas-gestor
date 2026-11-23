package ar.org.proyungas.infrastructure.output.persistence.plantypehistory.create;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.PlanTypeHistory;
import ar.org.proyungas.domain.output.plantypehistory.PlanTypeHistoryOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.plantypehistory.repository.PlanTypeHistoryRepository;
import ar.org.proyungas.shared.infrastructure.input.AuditLogBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class PlanTypeHistoryCreateJpaPersistenceAdapter implements PlanTypeHistoryOutputPort{
	
    private final PlanTypeHistoryRepository repository;
    private final PlanTypeHistoryMapper mapper;

	@Override
	public void perform(PlanTypeHistory domain) {
		
        log.info("Starting perform PlanTypeHistoryCreateJpaPersistenceAdapter with data: {}", domain);
        try {
        	repository.save(mapper.toEntity(domain));
        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing PlanTypeHistoryCreateJpaPersistenceAdapter with data {}", domain, e);
            throw new AuditLogBadRequestException(ErrorCode.AUDIT_LOG_BAD_REQUEST);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing PlanTypeHistoryCreateJpaPersistenceAdapter with data {}", domain, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
