package ar.org.proyungas.infrastructure.input.user.create;


import org.mapstruct.Mapper;

import ar.org.proyungas.application.user.create.RoleCreateCommand;


@Mapper(componentModel = "spring")
public interface RoleCreateRestMapper {
    RoleCreateCommand toCommand(RoleCreateRequest request);
}
