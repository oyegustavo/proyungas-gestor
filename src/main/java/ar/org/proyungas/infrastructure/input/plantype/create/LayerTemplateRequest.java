package ar.org.proyungas.infrastructure.input.plantype.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayerTemplateRequest {
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
}
