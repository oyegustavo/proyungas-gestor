package ar.org.proyungas.infrastructure.input.plantype.create;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResponse {
	Integer id;
	String username;
	String fullname;
	String email;
}
