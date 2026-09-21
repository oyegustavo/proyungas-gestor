package ar.org.proyungas.application.user.update;


import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.Role;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleUpdateMapper {
    Role toDomain(RoleUpdateCommand command);
    RoleUpdateResult toResult(Role role);
}
