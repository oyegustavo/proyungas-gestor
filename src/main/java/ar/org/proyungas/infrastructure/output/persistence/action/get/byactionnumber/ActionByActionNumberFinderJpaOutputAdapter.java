package ar.org.proyungas.infrastructure.output.persistence.action.get.byactionnumber;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionByActionNumberOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.action.create.ActionPersistenceMapper;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.repository.ActionRepository;
import ar.org.proyungas.shared.infrastructure.input.ActionNotFoundException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class ActionByActionNumberFinderJpaOutputAdapter implements ActionByActionNumberOutputPort {

	private final ActionRepository repository;
	private final ActionPersistenceMapper mapper;

	@Override
	public Action perform(String actionNumber) {
		log.info("Starting ActionByActionNumberFinderJpaOutputAdapter actionNumber: {}", actionNumber);

		try {
			ActionEntity actionEntity = repository.findByActionNumber(actionNumber)
					.orElseThrow(() -> new ActionNotFoundException(ErrorCode.ACTION_NOT_FOUND));

			return mapper.toDomain(actionEntity);
		} catch (DataAccessException e) {
			log.error(
					"Database connection error while performing ActionByActionNumberFinderJpaOutputAdapter with actionNumber: {}",
					actionNumber, e);
			throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
		}
	}

}
