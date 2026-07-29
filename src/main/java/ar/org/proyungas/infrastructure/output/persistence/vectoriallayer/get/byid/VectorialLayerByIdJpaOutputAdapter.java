package ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.get.byid;

import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.domain.output.action.VectorialLayerByIdFinderOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;
import ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.repository.VectorialLayerRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.VectorialLayerNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class VectorialLayerByIdJpaOutputAdapter implements VectorialLayerByIdFinderOutputPort{

    private final VectorialLayerByIdFinderAdapterMapper mapper;
    private final VectorialLayerRepository repository;
	
	@Override
	public VectorialLayer perform(UUID id) {
        log.info("Start perform VectorialLayerByIdJpaOutputAdapter with: {}", id);
        
        try {
        	VectorialLayerEntity entity = repository.findById(id).orElseThrow(
                    () -> new VectorialLayerNotFoundException(ErrorCode.VECTORIAL_LAYER_NOT_FOUND));
            log.info("LayerTemplateByIdJpaOutputAdapter performed successfully with: {}", id);
            return mapper.toDomain(entity);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing VectorialLayerByIdJpaOutputAdapter with: {}", id, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
