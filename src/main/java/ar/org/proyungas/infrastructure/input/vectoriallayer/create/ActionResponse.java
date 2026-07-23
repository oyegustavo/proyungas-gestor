package ar.org.proyungas.infrastructure.input.vectoriallayer.create;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionResponse {
	UUID id;
}
