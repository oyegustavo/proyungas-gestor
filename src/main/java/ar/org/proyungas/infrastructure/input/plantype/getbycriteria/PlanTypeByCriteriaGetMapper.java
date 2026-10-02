package ar.org.proyungas.infrastructure.input.plantype.getbycriteria;

import org.mapstruct.Mapper;

import ar.org.proyungas.application.plantype.get.bycriteria.PlanTypeByCriteriaFinderResult;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;

@Mapper(componentModel = "spring")
public interface PlanTypeByCriteriaGetMapper {
    PageResult<PlanTypeByCriteriaGetResponse> toResponse(PageResult<PlanTypeByCriteriaFinderResult> results);
}
