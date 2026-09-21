package ar.org.proyungas.domain.output.user;

import ar.org.proyungas.domain.models.Role;

public interface RoleByIdFinderOutputPort {
	Role perform(Integer id);
}