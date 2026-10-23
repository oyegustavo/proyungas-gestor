package ar.org.proyungas.infrastructure.input.layer.update;

import java.util.UUID;

import ar.org.proyungas.infrastructure.input.vectoriallayer.update.VectorialLayerUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayerUpdateRequest {
	@NotNull
	UUID id;
	@Valid
	VectorialLayerUpdateRequest vectorialLayerUpdateRequest;
}
