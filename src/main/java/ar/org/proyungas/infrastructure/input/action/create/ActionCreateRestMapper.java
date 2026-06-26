package ar.org.proyungas.infrastructure.input.action.create;

import org.mapstruct.Mapper;

import ar.org.proyungas.application.action.create.ActionCreateCommand;
import ar.org.proyungas.application.action.create.ActionCreateResult;

@Mapper(componentModel = "spring")
public interface ActionCreateRestMapper {
    ActionCreateCommand toCommand(ActionCreateRequest request);
    ActionCreateResponse toResponse(ActionCreateResult result);
}
