package ar.org.proyungas.infrastructure.input.layertemplate.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayerTemplateCreateRequest {
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
	PlanTypeRequest planType;
}
