package ar.org.proyungas.domain.models;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class VectorialLayer {
	UUID id;
	LayerTemplate templateLayer;
	String currentStatus;
	UUID technicianAssignedId;
	UUID currentVersionId;
	Boolean reinstatedFromOmitted;
}
