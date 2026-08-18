package ar.org.proyungas.infrastructure.output.persistence.layerstatushistory.create;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.LayerStatusHistory;
import ar.org.proyungas.domain.output.action.LayerStatusHistoryOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.layerstatushistory.repository.LayerStatusHistoryRepository;
import ar.org.proyungas.shared.infrastructure.input.AuditLogBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class LayerStatusHistoryCreateJpaPersistenceAdapter implements LayerStatusHistoryOutputPort{

    private final LayerStatusHistoryRepository repository;
    private final LayerStatusHistoryMapper mapper;
	
	@Override
	public void perform(LayerStatusHistory layerStatusHistory) {
        log.info("Starting perform LayerStatusHistoryCreateJpaPersistenceAdapter with data: {}", layerStatusHistory);
        try {
        	repository.save(mapper.toEntity(layerStatusHistory));
        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing LayerStatusHistoryCreateJpaPersistenceAdapter with data {}", layerStatusHistory, e);
            throw new AuditLogBadRequestException(ErrorCode.AUDIT_LOG_BAD_REQUEST);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing LayerStatusHistoryCreateJpaPersistenceAdapter with data {}", layerStatusHistory, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
