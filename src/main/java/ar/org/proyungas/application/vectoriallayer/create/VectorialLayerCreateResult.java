package ar.org.proyungas.application.vectoriallayer.create;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class VectorialLayerCreateResult {
	UUID id;
	ActionResult action;
	LayerTemplateCreateResult templateLayer;
	String currentStatus;
	Integer technicianAssignedId;
	UUID currentVersionId;
	Boolean reinstatedFromOmitted;
}
