package ar.org.proyungas.application.action.get.bycriteria;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;

@Mapper(componentModel = "spring")
public interface ActionByCriteriaFinderMapper {
	ActionByCriteriaFinderResult toResult(Action action);
	PageResult<ActionByCriteriaFinderResult> toResult(PageDomain<Action> domain);
}
