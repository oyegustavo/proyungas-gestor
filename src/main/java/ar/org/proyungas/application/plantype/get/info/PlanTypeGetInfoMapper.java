package ar.org.proyungas.application.plantype.get.info;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeGetInfoMapper {
	PlanTypeInfoResult toResult(PlanTypeInfoDto dtoO);
}
