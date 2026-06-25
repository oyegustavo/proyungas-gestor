package ar.org.proyungas.infrastructure.input.action.create;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserCreateResponse {
	UUID id;
	String username;
	String fullname;
	String email;
}
