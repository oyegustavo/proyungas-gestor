package ar.org.proyungas.application.action.get.bycriteria;

import ar.org.proyungas.shared.infrastructure.utils.PageResult;

public interface ActionByCriteriaFinder {
	   PageResult<ActionByCriteriaFinderResult> perform(ActionByCriteriaFinderQuery query);
}
