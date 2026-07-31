package ar.org.proyungas.infrastructure.output.persistence.auditlog.create;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.auditlog.repository.AuditLogRepository;
import ar.org.proyungas.shared.infrastructure.input.AuditLogBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class AuditLogCreateJpaPersistenceAdapter implements AuditLogOutputPort{

    private final AuditLogRepository repository;
    private final AuditLogMapper mapper;
	
	@Override
	public void perform(AuditLog auditLog) {
        log.info("Starting perform AuditLogCreateJpaPersistenceAdapter with data: {}", auditLog);
        try {
        	repository.save(mapper.toEntity(auditLog));
        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing AuditLogCreateJpaPersistenceAdapter with data {}", auditLog, e);
            throw new AuditLogBadRequestException(ErrorCode.AUDIT_LOG_BAD_REQUEST);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing AuditLogCreateJpaPersistenceAdapter with data {}", auditLog, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
}
