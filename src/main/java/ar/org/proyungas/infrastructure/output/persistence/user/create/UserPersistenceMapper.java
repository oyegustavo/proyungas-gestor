package ar.org.proyungas.infrastructure.output.persistence.user.create;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.infrastructure.output.persistence.entities.UserEntity;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserPersistenceMapper {
	User toDomain(UserEntity entity);
	UserEntity toEntity(User user);
}
