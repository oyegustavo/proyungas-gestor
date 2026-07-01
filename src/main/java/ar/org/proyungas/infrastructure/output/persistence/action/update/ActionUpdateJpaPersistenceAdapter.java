package ar.org.proyungas.infrastructure.output.persistence.action.update;

import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionUpdateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.action.create.ActionPersistenceMapper;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.repository.ActionRepository;
import ar.org.proyungas.shared.infrastructure.input.ActionBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.ActionNotFoundException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class ActionUpdateJpaPersistenceAdapter implements ActionUpdateOutputPort{
	
    private final ActionPersistenceMapper actionPersistenceMapper;
    private final ActionRepository actionRepository;

	@Override
	public Action perform(Action action) {
        log.info("Starting perform ActionSaveJpaPersistenceAdapter with data: {}", action);
        try {
        	Optional<ActionEntity> actionEntity = actionRepository.findByActionNumber(action.getActionNumber());
        	if (!actionEntity.isPresent()) {
        		log.error("Action Number provided not found!");
				throw new ActionNotFoundException(ErrorCode.ACTION_NOT_FOUND);
			}
        	
        	return actionPersistenceMapper.toDomain(actionRepository.save(buildActionEntity(actionEntity, action)));

        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing ActionSaveJpaPersistenceAdapter with data {}", action, e);
            throw new ActionBadRequestException(ErrorCode.INVALID_ACTION_ERROR);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing ActionSaveJpaPersistenceAdapter with data {}", action, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
	
	private ActionEntity buildActionEntity(Optional<ActionEntity> optionalEntity, Action action) {
		ActionEntity existingEntity = optionalEntity.get();
		existingEntity.setApplicantId(action.getApplicantId());
		existingEntity.setDerivativeStatus(action.getDerivativeStatus());
		existingEntity.setUploadedById(action.getUploadedById());
		return existingEntity;
	}
}
