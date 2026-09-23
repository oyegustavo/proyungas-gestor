package ar.org.proyungas.domain.output.user;

import ar.org.proyungas.domain.models.User;

public interface UserByUsernameOutputPort {
	User peform(String username);
}
