package ar.org.proyungas.application.vectoriallayer.create;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.domain.output.action.LayerTemplateByIdFinderOutputPort;
import ar.org.proyungas.domain.output.action.VectorialLayerCreateOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.repository.VectorialLayerStatusConfigurationProperties;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class VectorialLayerCreateUseCase implements VectorialLayerCreator{

    private final VectorialLayerCreateMapper mapper;
    private final VectorialLayerCreateOutputPort outputPort;
	private final LayerTemplateByIdFinderOutputPort layerTemplateByIdFinderOutputPort;
    private final VectorialLayerStatusConfigurationProperties vectorialLayerStatus;
    
	@Override
	public VectorialLayerCreateResult perform(VectorialLayerCreateCommand command, HttpServletRequest request) {
        log.info("Start performing VectorialLayerCreateUseCase with data: {}", command);
        LayerTemplate layerTemplate = layerTemplateByIdFinderOutputPort.perform(command.getTemplateLayer().getId());
        VectorialLayer vectorialLayer = mapper.toDomain(command);
        
		return mapper.toResult(outputPort.perform(
		        vectorialLayer
		        .withTemplateLayer(layerTemplate)
		        .withCurrentStatus(vectorialLayerStatus.getWithoutPresenting())
		        .withCurrentVersion(null)
				));
	}
}
