package ar.org.proyungas.infrastructure.input.user.getbyusername;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserGetByUsernameResponse {
    Integer id;
    String username;
    String fullname;
    String email;
    String password;
    Boolean enabled;
}
