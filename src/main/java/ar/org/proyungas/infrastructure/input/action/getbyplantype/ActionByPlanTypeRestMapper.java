package ar.org.proyungas.infrastructure.input.action.getbyplantype;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.action.get.byplantype.ActionByPlanTypeFinderResult;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionByPlanTypeRestMapper {
	ActionByPlanTypeResponse toResponse(ActionByPlanTypeFinderResult result);
	List<ActionByPlanTypeResponse> toResponse(List<ActionByPlanTypeFinderResult> results);
}
