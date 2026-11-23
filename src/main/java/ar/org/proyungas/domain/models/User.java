package ar.org.proyungas.domain.models;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data 
public class User {
	Integer id;
	String username;
	String fullname;
	String email;
	String password;
	Boolean enabled;
	List<Role> roles;
}
