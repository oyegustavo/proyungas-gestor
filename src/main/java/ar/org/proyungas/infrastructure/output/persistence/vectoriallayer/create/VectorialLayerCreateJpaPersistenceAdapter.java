package ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.create;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.domain.output.action.VectorialLayerCreateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerTemplateEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;
import ar.org.proyungas.infrastructure.output.persistence.repository.ActionRepository;
import ar.org.proyungas.infrastructure.output.persistence.repository.LayerTemplateRepository;
import ar.org.proyungas.infrastructure.output.persistence.repository.VectorialLayerRepository;
import ar.org.proyungas.shared.infrastructure.input.ActionNotFoundException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.LayerTemplateNotFoundException;
import ar.org.proyungas.shared.infrastructure.input.VectorialLayerBadRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class VectorialLayerCreateJpaPersistenceAdapter implements VectorialLayerCreateOutputPort{

    private final VectorialLayerMapper mapper;
    private final VectorialLayerRepository repository;
    private final LayerTemplateRepository layerTemplateRepository;
    private final ActionRepository actionRepository;
    
	
	@Override
	public VectorialLayer perform(VectorialLayer vectorialLayer) {
        log.info("Starting perform VectorialLayerCreateJpaPersistenceAdapter with data: {}", vectorialLayer);
        try {
        	
        	VectorialLayerEntity vectorialLayerEntity = mapper.toEntity(vectorialLayer);
        	
        	ActionEntity actionEntity = actionRepository.findById(vectorialLayer.getAction().getId())
        	.orElseThrow(()-> new ActionNotFoundException(ErrorCode.ACTION_NOT_FOUND));
        	
        	vectorialLayerEntity.setAction(actionEntity);
        	
        	LayerTemplateEntity layerTemplateEntity = layerTemplateRepository.
        	findById(vectorialLayer.getTemplateLayer().getId())
        	.orElseThrow(() -> new LayerTemplateNotFoundException(ErrorCode.LAYER_TEMPLATE_NOT_FOUND_ERROR));
        	
        	vectorialLayerEntity.setTemplateLayer(layerTemplateEntity);
        	
        	return mapper.toDomain(repository.save(vectorialLayerEntity));
        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing VectorialLayerCreateJpaPersistenceAdapter with data {}", vectorialLayer, e);
            throw new VectorialLayerBadRequestException(ErrorCode.INVALID_VECTORIAL_LAYER_ERROR);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing VectorialLayerCreateJpaPersistenceAdapter with data {}", vectorialLayer, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
}