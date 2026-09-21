package ar.org.proyungas.application.vectoriallayer.update;

import java.util.UUID;

import ar.org.proyungas.application.vectoriallayer.create.ActionCommand;
import ar.org.proyungas.application.vectoriallayer.create.LayerTemplateCommand;
import ar.org.proyungas.application.vectoriallayer.create.LayerVersionCommand;
import ar.org.proyungas.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VectorialLayerUpdateCommand {
	LayerTemplateCommand templateLayer;
	ActionCommand action;
	LayerVersionCommand layerVersion;
	String currentStatus;
	User technicianAssigned;
	UUID currentVersionId;
	Boolean reinstatedFromOmitted;
}
