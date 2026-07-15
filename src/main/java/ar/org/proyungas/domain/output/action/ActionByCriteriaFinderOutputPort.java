package ar.org.proyungas.domain.output.action;

import java.util.List;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.shared.infrastructure.utils.Filter;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;

public interface ActionByCriteriaFinderOutputPort {
	 PageDomain<Action> perform(Integer page, Integer size, List<Filter> filters);
}
