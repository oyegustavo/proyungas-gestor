package ar.org.proyungas.infrastructure.input.vectoriallayer.create;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class LayerTemplateCreateResponse {
	UUID id;
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
	LocalDateTime createdAt;
	PlanTypeCreateResponse planType;
}
