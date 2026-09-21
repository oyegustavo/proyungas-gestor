package ar.org.proyungas.application.user.create;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserCreateResult {
	Integer id;
	String username;
	String fullname;
	String email;
	String password;
	Boolean enabled;
	List<RoleCreateResult> roles;
}
