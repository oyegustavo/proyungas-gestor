package ar.org.proyungas.infrastructure.output.persistence.role.get;


import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.Role;
import ar.org.proyungas.infrastructure.output.persistence.entities.RoleEntity;

@Mapper(componentModel = "spring")
public interface RoleByIdFinderAdapterMapper {
	Role toDomain(RoleEntity entity);
}
