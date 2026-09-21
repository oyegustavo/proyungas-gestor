package ar.org.proyungas.infrastructure.input.user.create;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserCreateResponse {
	Integer id;
	String username;
	String fullname;
	String email;
	String password;
	Boolean enabled;
	List<RoleCreateResponse> roles;
}
