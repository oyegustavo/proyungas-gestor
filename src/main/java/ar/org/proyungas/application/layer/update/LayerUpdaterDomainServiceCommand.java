package ar.org.proyungas.application.layer.update;

import java.util.UUID;

import ar.org.proyungas.application.vectoriallayer.update.VectorialLayerUpdateCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LayerUpdaterDomainServiceCommand {
	UUID id;
	VectorialLayerUpdateCommand command;
}
