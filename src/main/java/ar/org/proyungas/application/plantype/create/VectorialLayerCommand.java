package ar.org.proyungas.application.plantype.create;

import ar.org.proyungas.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VectorialLayerCommand {
	LayerTemplateCommand templateLayer;
	String currentStatus;
	User technicianAssigned;
	String observation;
}
