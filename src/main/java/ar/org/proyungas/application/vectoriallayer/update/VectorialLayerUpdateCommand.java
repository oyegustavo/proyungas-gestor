package ar.org.proyungas.application.vectoriallayer.update;

import java.util.UUID;

import ar.org.proyungas.application.vectoriallayer.create.ActionCommand;
import ar.org.proyungas.application.vectoriallayer.create.LayerTemplateCommand;
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
	String currentStatus;
	UUID technicianAssignedId;
	UUID currentVersionId;
	Boolean reinstatedFromOmitted;
}
