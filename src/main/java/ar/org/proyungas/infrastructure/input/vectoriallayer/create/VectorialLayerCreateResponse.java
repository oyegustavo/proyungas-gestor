package ar.org.proyungas.infrastructure.input.vectoriallayer.create;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class VectorialLayerCreateResponse {
	UUID id;
	ActionResponse action;
	LayerTemplateCreateResponse templateLayer;
	String currentStatus;
	Integer technicianAssignedId;
	UUID currentVersionId;
	Boolean reinstatedFromOmitted;
}
