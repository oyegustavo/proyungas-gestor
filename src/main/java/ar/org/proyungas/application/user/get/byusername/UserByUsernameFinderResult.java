package ar.org.proyungas.application.user.get.byusername;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserByUsernameFinderResult {
	Integer id;
	String username;
	String fullname;
	String email;
	String password;
	Boolean enabled;
}
