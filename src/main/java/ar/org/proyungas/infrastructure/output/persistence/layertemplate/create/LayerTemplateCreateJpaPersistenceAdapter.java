package ar.org.proyungas.infrastructure.output.persistence.layertemplate.create;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.domain.output.layertemplate.LayerTemplateCreateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.layertemplate.repository.LayerTemplateRepository;
import ar.org.proyungas.shared.infrastructure.input.ActionBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class LayerTemplateCreateJpaPersistenceAdapter implements LayerTemplateCreateOutputPort{
	
    private final LayerTemplatePersistenceMapper mapper;
    private final LayerTemplateRepository repository;

	@Override
	public LayerTemplate perform(LayerTemplate layerTemplate) {
		
        log.info("Starting perform LayerTemplateCreateJpaPersistenceAdapter with data: {}", layerTemplate);
        try {
        	
        	return mapper.toDomain(repository.save(mapper.toEntity(layerTemplate)));

        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing LayerTemplateCreateJpaPersistenceAdapter with data {}", layerTemplate, e);
            throw new ActionBadRequestException(ErrorCode.INVALID_ACTION_ERROR);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing LayerTemplateCreateJpaPersistenceAdapter with data {}", layerTemplate, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
}
