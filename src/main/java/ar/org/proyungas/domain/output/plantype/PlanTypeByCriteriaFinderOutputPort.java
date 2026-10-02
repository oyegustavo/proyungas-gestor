package ar.org.proyungas.domain.output.plantype;

import java.util.List;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.shared.infrastructure.utils.Filter;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;

public interface PlanTypeByCriteriaFinderOutputPort {
	 PageDomain<PlanType> perform(Integer page, Integer size, List<Filter> filters);
}
