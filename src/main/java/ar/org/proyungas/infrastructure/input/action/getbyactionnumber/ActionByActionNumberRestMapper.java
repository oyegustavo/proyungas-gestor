package ar.org.proyungas.infrastructure.input.action.getbyactionnumber;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.action.get.byactionnumber.ActionByActionNumberResult;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionByActionNumberRestMapper {
	ActionByActionNumberResponse toResponse(ActionByActionNumberResult result);
}
