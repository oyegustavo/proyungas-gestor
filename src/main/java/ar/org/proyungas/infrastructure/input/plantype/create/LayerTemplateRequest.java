package ar.org.proyungas.infrastructure.input.plantype.create;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayerTemplateRequest {
	@JsonProperty("layer_code")
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
    @Builder.Default
    private Boolean active = true; 
}
