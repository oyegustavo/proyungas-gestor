package ar.org.proyungas.application.vectoriallayer.update;

import java.util.UUID;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.domain.output.action.ActionByIdOutputPort;
import ar.org.proyungas.domain.output.action.AuditLogOutputPort;
import ar.org.proyungas.domain.output.action.LayerTemplateByIdFinderOutputPort;
import ar.org.proyungas.domain.output.action.VectorialLayerByIdFinderOutputPort;
import ar.org.proyungas.domain.output.action.VectorialLayerUpdateOutputPort;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class VectorialLayerUpdateUseCase implements VectorialLayerUpdater{

    private final VectorialLayerUpdateOutputPort outputPort;
    private final VectorialLayerByIdFinderOutputPort vectorialLayerByIdFinderOutputPort;
    private final ActionByIdOutputPort actionByIdOutputPort;
    private final LayerTemplateByIdFinderOutputPort layerTemplateByIdFinderOutputPort;
	
	@Override
	public void perform(VectorialLayerUpdateCommand command, UUID id ,HttpServletRequest request) {
        log.info("Start performing VectorialLayerUpdateUseCase with data: {}", command);
        VectorialLayer vectorialLayer = vectorialLayerByIdFinderOutputPort.perform(id);
        outputPort.perform(applyUpdates(vectorialLayer, command));
	}
	
	private VectorialLayer applyUpdates(VectorialLayer vectorialLayer, VectorialLayerUpdateCommand command) {
	    VectorialLayer updated = vectorialLayer;

	    if (command.getAction() != null) {
	        Action action = actionByIdOutputPort.perform(command.getAction().getId());
	        updated = updated.withAction(action);
	    }

	    if (command.getTemplateLayer() != null) {
	        LayerTemplate template = layerTemplateByIdFinderOutputPort.perform(command.getTemplateLayer().getId());
	        updated = updated.withTemplateLayer(template);
	    }

	    if (command.getCurrentStatus() != null) {
	        updated = updated.withCurrentStatus(command.getCurrentStatus());
	    }

	    if (command.getCurrentVersionId() != null) {
	        updated = updated.withCurrentVersionId(command.getCurrentVersionId());
	    }

	    if (command.getReinstatedFromOmitted() != null) {
	        updated = updated.withReinstatedFromOmitted(command.getReinstatedFromOmitted());
	    }

	    if (command.getTechnicianAssignedId() != null) {
	        updated = updated.withTechnicianAssignedId(command.getTechnicianAssignedId());
	    }

	    return updated;
	}
}
