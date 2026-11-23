package ar.org.proyungas.infrastructure.input.plantypehistory.getbyplantype;

import java.util.List;

import org.mapstruct.Mapper;

import ar.org.proyungas.application.plantypehistory.get.byplantype.PlanTypeHistoryByPlanTypeResult;

@Mapper(componentModel = "spring")
public interface PlanTypeHistoryByPlanTypeRestMapper {
	List<PlanTypeHistoryByPlanTypeResponse> toResponse(List<PlanTypeHistoryByPlanTypeResult> response);
}
