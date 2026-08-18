package ar.org.proyungas.infrastructure.output.persistence.layerversion.get.byid;

import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.LayerVersion;
import ar.org.proyungas.domain.output.action.LayerVersionByIdFinderOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerVersionEntity;
import ar.org.proyungas.infrastructure.output.persistence.layerversion.repository.LayerVersionRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.LayerVersionNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Component
@Slf4j
@AllArgsConstructor
public class LayerVersionByIdJpaOutputAdapter implements LayerVersionByIdFinderOutputPort{

    private final LayerVersionByIdFinderAdapterMapper mapper;
    private final LayerVersionRepository repository;
	
	@Override
	public LayerVersion perform(UUID id) {
        log.info("Start perform LayerVersionByIdJpaOutputAdapter with: {}", id);
        
        try {
        	LayerVersionEntity entity = repository.findById(id).orElseThrow(
                    () -> new LayerVersionNotFoundException(ErrorCode.LAYER_VERSION_NOT_FOUND_ERROR));
            log.info("LayerVersionByIdJpaOutputAdapter performed successfully with: {}", id);
            return mapper.toDomain(entity);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing LayerVersionByIdJpaOutputAdapter with: {}", id, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
