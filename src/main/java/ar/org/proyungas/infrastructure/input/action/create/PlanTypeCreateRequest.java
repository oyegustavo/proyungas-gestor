package ar.org.proyungas.infrastructure.input.action.create;

import java.util.UUID;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanTypeCreateRequest {
	@Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
	private UUID id;
}
