package ar.org.proyungas.application.plantypehistory.get.byplantype;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.PlanTypeHistory;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeHistoryGetByPlanTypeMapper {
	PlanTypeHistoryByPlanTypeResult toResult(PlanTypeHistory domain);
	List<PlanTypeHistoryByPlanTypeResult> toResult(List<PlanTypeHistory> domains);
}
