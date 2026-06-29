package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
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
	LocalDateTime createdAt;
	PlanType planType;
}
