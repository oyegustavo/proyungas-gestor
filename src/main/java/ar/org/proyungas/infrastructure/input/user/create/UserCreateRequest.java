package ar.org.proyungas.infrastructure.input.user.create;


import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserCreateRequest {
	@NotNull(message = "username must not be null")
	String username;
	@NotNull(message = "fullname must not be null")
	String fullname;
	@NotNull(message = "email must not be null")
	String email;
	String password;
	Boolean enabled;
	List<RoleCreateRequest> roles;
}
