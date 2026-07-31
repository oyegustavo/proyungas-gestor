package ar.org.proyungas.infrastructure.output.persistence.layertemplate.get.byid;

import java.util.UUID;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.domain.output.action.LayerTemplateByIdFinderOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerTemplateEntity;
import ar.org.proyungas.infrastructure.output.persistence.layertemplate.repository.LayerTemplateRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.LayerTemplateNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class LayerTemplateByIdJpaOutputAdapter implements LayerTemplateByIdFinderOutputPort{

    private final LayerTemplateByIdFinderAdapterMapper mapper;
    private final LayerTemplateRepository repository;
	
	@Override
	public LayerTemplate perform(UUID id) {
        log.info("Start perform LayerTemplateByIdJpaOutputAdapter with: {}", id);
        
        try {
        	LayerTemplateEntity entity = repository.findById(id).orElseThrow(
                    () -> new LayerTemplateNotFoundException(ErrorCode.LAYER_TEMPLATE_NOT_FOUND_ERROR));
            log.info("LayerTemplateByIdJpaOutputAdapter performed successfully with: {}", id);
            return mapper.toDomain(entity);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing LayerTemplateByIdJpaOutputAdapter with: {}", id, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
