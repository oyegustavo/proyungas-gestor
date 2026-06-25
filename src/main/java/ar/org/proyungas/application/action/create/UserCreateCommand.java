package ar.org.proyungas.application.action.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateCommand {
    private String username;
    private String fullname;
    private String email;
}
