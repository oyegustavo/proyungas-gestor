package ar.org.proyungas.infrastructure.input.plantype.getinfo;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.plantype.get.info.PlanTypeInfoResult;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeGetInfoRestMapper {
	PlanTypeInfoResponse toResponse(PlanTypeInfoResult result);
}
