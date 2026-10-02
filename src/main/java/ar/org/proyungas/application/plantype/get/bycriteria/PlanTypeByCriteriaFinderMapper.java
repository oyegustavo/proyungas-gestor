package ar.org.proyungas.application.plantype.get.bycriteria;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;

@Mapper(componentModel = "spring")
public interface PlanTypeByCriteriaFinderMapper {
	
	PlanTypeByCriteriaFinderResult toResult(PlanType user);
	
	PageResult<PlanTypeByCriteriaFinderResult> toResult(PageDomain<PlanType> domain);
}
