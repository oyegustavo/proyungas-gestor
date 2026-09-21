package ar.org.proyungas.infrastructure.input.user.update;


import org.mapstruct.Mapper;

import ar.org.proyungas.application.user.update.RoleUpdateCommand;


@Mapper(componentModel = "spring")
public interface RoleUpdateRestMapper {
    RoleUpdateCommand toCommand(RoleUpdateRequest request);
}
