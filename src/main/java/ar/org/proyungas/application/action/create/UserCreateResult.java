package ar.org.proyungas.application.action.create;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserCreateResult {
	Integer id;
	String username;
	String fullname;
	String email;
	Boolean enabled;
}
