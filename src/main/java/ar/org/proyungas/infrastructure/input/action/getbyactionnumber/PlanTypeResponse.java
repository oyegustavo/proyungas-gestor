package ar.org.proyungas.infrastructure.input.action.getbyactionnumber;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeResponse {
	UUID id;
    String name;
}
