package ar.org.proyungas.domain.output.user;

import ar.org.proyungas.domain.models.User;

public interface UserSaveOutputPort {
	User perform(User user);
}
