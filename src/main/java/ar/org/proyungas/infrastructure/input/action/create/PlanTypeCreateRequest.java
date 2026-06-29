package ar.org.proyungas.infrastructure.input.action.create;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanTypeCreateRequest {
	private UUID id;
}
