package ar.org.proyungas.application.user.create;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserCreateMapper {
	UserCreateResult toResult(User user);
	User toDomain(UserCreateCommand commmand);
}
