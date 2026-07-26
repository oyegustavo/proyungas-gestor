package ar.org.proyungas.infrastructure.input.vectoriallayer.update;

import java.util.UUID;

import ar.org.proyungas.infrastructure.input.vectoriallayer.create.ActionRequest;
import ar.org.proyungas.infrastructure.input.vectoriallayer.create.LayerTemplateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VectorialLayerUpdateRequest {
	LayerTemplateRequest templateLayer;
	ActionRequest action;
	String currentStatus;
	UUID technicianAssignedId;
	UUID currentVersionId;
	Boolean reinstatedFromOmitted;
}
