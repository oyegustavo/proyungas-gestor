package ar.org.proyungas.infrastructure.output.persistence.action.get.byid;

import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionByIdOutputPort;
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
public class ActionByIdJpaOutputAdapter implements ActionByIdOutputPort{

    private final ActionByIdFinderAdapterMapper mapper;
    private final ActionRepository repository;
	
	@Override
	public Action perform(UUID id) {
        log.info("Start perform ActionByIdJpaOutputAdapter with: {}", id);
        
        try {
        	ActionEntity entity = repository.findById(id).orElseThrow(
                    () -> new ActionNotFoundException(ErrorCode.ACTION_NOT_FOUND));
            log.info("ActionByIdJpaOutputAdapter performed successfully with: {}", id);
            return mapper.toDomain(entity);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing VectorialLayerByIdJpaOutputAdapter with: {}", id, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
}
