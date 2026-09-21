package ar.org.proyungas.infrastructure.input.action.create;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserCreateResponse {
	Integer id;
	String username;
	String fullname;
	String email;
}
