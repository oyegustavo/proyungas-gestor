package ar.org.proyungas.infrastructure.input.action.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.action.create.ActionCreateCommand;
import ar.org.proyungas.application.action.create.ActionCreateResult;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionCreateRestMapper {
    ActionCreateCommand toCommand(ActionCreateRequest request);
    ActionCreateResponse toResponse(ActionCreateResult result);
}
