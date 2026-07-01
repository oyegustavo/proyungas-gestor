package ar.org.proyungas.application.action.get.byactionnumber;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.Action;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionByActionNumberMapper {
	ActionByActionNumberResult toResult(Action action);
}
