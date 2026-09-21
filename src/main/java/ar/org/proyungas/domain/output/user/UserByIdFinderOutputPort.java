package ar.org.proyungas.domain.output.user;

import ar.org.proyungas.domain.models.User;

public interface UserByIdFinderOutputPort {
	User peform(Integer id);
}
