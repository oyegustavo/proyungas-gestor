package ar.org.proyungas.infrastructure.input.plantype.create;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class VectorialLayerResponse {
	UUID id;
	String currentStatus;
	UserResponse technicianAssigned;
	String observation;
	LayerVersionResponse currentVersion;
	Boolean reinstatedFromOmitted;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
