package ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.update;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.domain.output.action.VectorialLayerUpdateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;
import ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.create.VectorialLayerMapper;
import ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.repository.VectorialLayerRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.VectorialLayerBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.VectorialLayerNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class VectorialLayerUpdateJpaPersistenceAdapter implements VectorialLayerUpdateOutputPort{

    private final VectorialLayerRepository repository;
    private final VectorialLayerMapper mapper;
	
	@Override
	public void perform(VectorialLayer vectorialLayer) {
        log.info("Starting perform VectorialLayerUpdateJpaPersistenceAdapter with data: {}", vectorialLayer);
        try {
        	VectorialLayerEntity entity = mapper.toEntity(vectorialLayer);
        	if (entity.getId() != null) {
        	    VectorialLayerEntity existing = repository.findById(
        	    		vectorialLayer.getId()).orElseThrow(()->
        	    		new VectorialLayerNotFoundException(ErrorCode.VECTORIAL_LAYER_NOT_FOUND));
        	    entity.setCreatedAt(existing.getCreatedAt()); 
        	}
        	repository.save(entity);
        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing VectorialLayerCreateJpaPersistenceAdapter with data {}", vectorialLayer, e);
            throw new VectorialLayerBadRequestException(ErrorCode.INVALID_VECTORIAL_LAYER_ERROR);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing VectorialLayerCreateJpaPersistenceAdapter with data {}", vectorialLayer, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
}
