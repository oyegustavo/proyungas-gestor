package ar.org.proyungas.infrastructure.input.layertemplate.create;

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
public class LayerTemplateCreateRequest {
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
	PlanTypeRequest planType;
}
