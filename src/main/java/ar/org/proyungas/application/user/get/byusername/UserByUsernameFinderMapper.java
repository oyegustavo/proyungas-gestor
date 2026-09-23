package ar.org.proyungas.application.user.get.byusername;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserByUsernameFinderMapper {
    UserByUsernameFinderResult toResult(User user);
}