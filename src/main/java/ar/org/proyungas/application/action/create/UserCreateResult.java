package ar.org.proyungas.application.action.create;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserCreateResult {
	UUID id;
	String username;
	String fullname;
	String email;
	Boolean enabled;
}
