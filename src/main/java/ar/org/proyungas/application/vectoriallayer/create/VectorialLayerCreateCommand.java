package ar.org.proyungas.application.vectoriallayer.create;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VectorialLayerCreateCommand {
	LayerTemplateCommand templateLayer;
	ActionCommand action;
	UUID technicianAssignedId;
	Boolean reinstatedFromOmitted;
}
