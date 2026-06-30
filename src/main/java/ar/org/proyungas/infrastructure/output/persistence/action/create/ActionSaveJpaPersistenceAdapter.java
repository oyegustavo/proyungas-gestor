package ar.org.proyungas.infrastructure.output.persistence.action.create;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionSaveOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;
import ar.org.proyungas.infrastructure.output.persistence.repository.ActionRepository;
import ar.org.proyungas.infrastructure.output.persistence.repository.PlanTypeRepository;
import ar.org.proyungas.shared.infrastructure.input.ActionBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.PlanTypeNotFoundException;
import ar.org.proyungas.shared.infrastructure.input.RepeatedActionNumberException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class ActionSaveJpaPersistenceAdapter implements ActionSaveOutputPort{
	
    private final ActionPersistenceMapper actionPersistenceMapper;
    private final ActionRepository actionRepository;
    private final PlanTypeRepository planTypeRepository;

	@Override
	public Action perform(Action action) {
        log.info("Starting perform ActionSaveJpaPersistenceAdapter with data: {}", action);
        try {
        	
        	if (!actionRepository.findByActionNumber(action.getActionNumber()).isEmpty()) {
        		log.error("Action Number provided already exists!");
				throw new RepeatedActionNumberException(ErrorCode.REPEATED_ACTION_NUMBER_ERROR);
			}
        	
    		ActionEntity actionEntity = new ActionEntity();
        	PlanTypeEntity planType = planTypeRepository.findById(action.getPlanType().getId())
        		    .orElseThrow(() -> new PlanTypeNotFoundException(ErrorCode.PLAN_TYPE_NOT_FOUND));
        		actionEntity.setPlanType(planType);
        		actionEntity.setActionNumber(action.getActionNumber());
        		actionEntity.setApplicantId(action.getApplicantId());
        		actionEntity.setPropertyOwner(action.getPropertyOwner());
        		actionEntity.setUploadedById(action.getUploadedById());
        		actionEntity.setActionNumber(action.getActionNumber());
        		actionEntity.setDerivativeStatus(action.getDerivativeStatus());
        	return actionPersistenceMapper.toDomain(actionRepository.save(actionEntity));

        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing ActionSaveJpaPersistenceAdapter with data {}", action, e);
            throw new ActionBadRequestException(ErrorCode.INVALID_ACTION_ERROR);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing ActionSaveJpaPersistenceAdapter with data {}", action, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
