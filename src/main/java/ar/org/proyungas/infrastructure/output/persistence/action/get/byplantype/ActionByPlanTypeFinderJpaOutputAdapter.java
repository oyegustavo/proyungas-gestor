package ar.org.proyungas.infrastructure.output.persistence.action.get.byplantype;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.action.ActionByPlanTypeOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.action.create.ActionPersistenceMapper;
import ar.org.proyungas.infrastructure.output.persistence.action.repository.ActionRepository;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.plantype.create.PlanTypePersistenceMapper;
import ar.org.proyungas.shared.infrastructure.input.ActionNotFoundException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class ActionByPlanTypeFinderJpaOutputAdapter implements ActionByPlanTypeOutputPort{

	private final ActionRepository repository;
	private final ActionPersistenceMapper mapper;
	private final PlanTypePersistenceMapper planTypeMapper;
	
	@Override
	public List<Action> perform(PlanType planType) {
		log.info("Starting ActionByPlanTypeFinderJpaOutputAdapter actionNumber: {}", planType);

		try {
			List<ActionEntity> actionEntity = repository.findByPlanType(planTypeMapper.toEntity(planType))
					.orElseThrow(() -> new ActionNotFoundException(ErrorCode.ACTION_NOT_FOUND));

			return mapper.toDomain(actionEntity);
		} catch (DataAccessException e) {
			log.error(
					"Database connection error while performing ActionByPlanTypeFinderJpaOutputAdapter with planType: {}",
					planType, e);
			throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
		}
	}

}
