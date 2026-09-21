package ar.org.proyungas.infrastructure.input.user.create;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoleCreateResponse {
	Integer id;
	String role; 	
}
