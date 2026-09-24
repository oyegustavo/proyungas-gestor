package ar.org.proyungas.infrastructure.input.user.getbyusername;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserGetByUsernameResponse {
    Integer id;
    String username;
    String password;
    Boolean enabled;
    List<RoleResponse> roles;
}
