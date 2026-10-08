package ar.org.proyungas.application.layertemplate.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayerTemplateCreateCommand {
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
	PlanTypeCommand planType;
}
