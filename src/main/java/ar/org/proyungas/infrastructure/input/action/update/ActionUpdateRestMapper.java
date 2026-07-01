package ar.org.proyungas.infrastructure.input.action.update;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.action.update.ActionUpdateCommand;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionUpdateRestMapper {
	ActionUpdateCommand toCommand(ActionUpdateRequest request);
}
