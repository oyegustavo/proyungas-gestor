package ar.org.proyungas.application.user.create;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoleCreateResult {
	Integer id;
	String role;
}
