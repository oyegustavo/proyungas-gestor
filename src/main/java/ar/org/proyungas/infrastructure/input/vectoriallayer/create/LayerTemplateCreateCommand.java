package ar.org.proyungas.infrastructure.input.vectoriallayer.create;

import java.time.LocalDateTime;

import ar.org.proyungas.application.action.create.PlanTypeCreateCommand;
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
	LocalDateTime createdAt;
	PlanTypeCreateCommand planType;
}
