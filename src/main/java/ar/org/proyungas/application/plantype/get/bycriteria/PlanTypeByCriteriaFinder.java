package ar.org.proyungas.application.plantype.get.bycriteria;

import ar.org.proyungas.shared.infrastructure.utils.PageResult;

public interface PlanTypeByCriteriaFinder {
	   PageResult<PlanTypeByCriteriaFinderResult> perform(PlanTypeByCriteriaFinderQuery query);
}
