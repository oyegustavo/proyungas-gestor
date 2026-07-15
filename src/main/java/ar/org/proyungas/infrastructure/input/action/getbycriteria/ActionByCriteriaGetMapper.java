package ar.org.proyungas.infrastructure.input.action.getbycriteria;

import org.mapstruct.Mapper;

import ar.org.proyungas.application.action.get.bycriteria.ActionByCriteriaFinderResult;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;

@Mapper(componentModel = "spring")
public interface ActionByCriteriaGetMapper {
    PageResult<ActionByCriteriaGetResponse> toResponse(PageResult<ActionByCriteriaFinderResult> results);
}
