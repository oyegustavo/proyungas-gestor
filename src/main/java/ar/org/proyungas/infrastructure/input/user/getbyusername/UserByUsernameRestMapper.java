package ar.org.proyungas.infrastructure.input.user.getbyusername;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.user.get.byusername.UserByUsernameFinderResult;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserByUsernameRestMapper {
	UserGetByUsernameResponse toResponse(UserByUsernameFinderResult result);
	
}
