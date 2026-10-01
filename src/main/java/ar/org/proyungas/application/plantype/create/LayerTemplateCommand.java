package ar.org.proyungas.application.plantype.create;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayerTemplateCommand {
	UUID id;
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
	LocalDateTime createdAt;
}
