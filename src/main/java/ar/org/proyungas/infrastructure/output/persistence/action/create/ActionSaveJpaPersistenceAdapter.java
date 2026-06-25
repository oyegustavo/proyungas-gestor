package ar.org.proyungas.infrastructure.output.persistence.action.create;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionSaveOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.repository.ActionRepository;
import ar.org.proyungas.shared.infrastructure.input.ActionBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class ActionSaveJpaPersistenceAdapter implements ActionSaveOutputPort{
	
    private final ActionPersistenceMapper actionPersistenceMapper;
    private final ActionRepository actionRepository;

	@Override
	public Action perform(Action action) {
        log.info("Start performing ActionSaveJpaPersistenceAdapter with data: {}", action);
        try {
            return actionPersistenceMapper.toDomain(actionRepository.save(actionPersistenceMapper.toEntity(action)));

        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing ActionSaveJpaPersistenceAdapter with data {}", action, e);
            throw new ActionBadRequestException(ErrorCode.INVALID_ACTION_ERROR);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing ActionSaveJpaPersistenceAdapter with data {}", action, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
	

}
