package ar.org.proyungas.infrastructure.input.vectoriallayer.create;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class VectorialLayerCreateRequest {
	LayerTemplateRequest templateLayer;
	ActionRequest action;
	LayerVersionRequest layerVersion;
	Integer technicianAssignedId;
	Boolean reinstatedFromOmitted;
}
