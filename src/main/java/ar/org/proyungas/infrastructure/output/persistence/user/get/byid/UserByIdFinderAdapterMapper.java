package ar.org.proyungas.infrastructure.output.persistence.user.get.byid;


import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.infrastructure.output.persistence.entities.UserEntity;


@Mapper(componentModel = "spring")
public interface UserByIdFinderAdapterMapper {
	User toDomain(UserEntity entity);
}
