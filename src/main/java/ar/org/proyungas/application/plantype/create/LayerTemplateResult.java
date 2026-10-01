package ar.org.proyungas.application.plantype.create;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LayerTemplateResult {
	UUID id;
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
	LocalDateTime createdAt;
}
