package ar.org.proyungas.infrastructure.input.user.getbyusername;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoleResponse {
	Integer id;
	String role;
}
