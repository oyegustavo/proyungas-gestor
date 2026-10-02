package ar.org.proyungas.infrastructure.input.plantype.create;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LayerTemplateResponse {
	UUID id;
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
    List<VectorialLayerResponse> vectorialLayers;
}
