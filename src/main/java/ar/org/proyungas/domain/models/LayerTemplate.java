package ar.org.proyungas.domain.models;

import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class LayerTemplate {
	UUID id;
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
    List<VectorialLayer> vectorialLayers;
}
