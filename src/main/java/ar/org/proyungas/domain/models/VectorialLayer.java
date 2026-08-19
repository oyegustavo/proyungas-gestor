package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
@With
public class VectorialLayer {
	UUID id;
	Action action;
	LayerTemplate templateLayer;
	String currentStatus;
	String technicianAssigned;
	String observation;
	LayerVersion currentVersion;
	Boolean reinstatedFromOmitted;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
