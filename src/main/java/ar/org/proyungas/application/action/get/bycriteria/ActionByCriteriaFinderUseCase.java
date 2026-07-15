package ar.org.proyungas.application.action.get.bycriteria;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionByCriteriaFinderOutputPort;
import ar.org.proyungas.shared.infrastructure.utils.Filter;
import ar.org.proyungas.shared.infrastructure.utils.FilterBuilder;
import ar.org.proyungas.shared.infrastructure.utils.FilterUtils;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ActionByCriteriaFinderUseCase implements ActionByCriteriaFinder{

    private final ActionByCriteriaFinderOutputPort actionByCriteriaFinderOutputPort;
    private final ActionByCriteriaFinderMapper mapper;

    private static final List<String> ALLOWED_FILTERS =
            Collections.unmodifiableList(Arrays.asList("actionNumber", "propertyOwner"));
	
	
	@Override
	public PageResult<ActionByCriteriaFinderResult> perform(ActionByCriteriaFinderQuery query) {
		
        FilterUtils.validateFiltersMap(query.getFilters(), ALLOWED_FILTERS);

        List<Filter> filters = new FilterBuilder().build(query.getFilters());

        PageDomain<Action> userPage = actionByCriteriaFinderOutputPort.perform(query.getPage(), query.getSize(), filters);

        return mapper.toResult(userPage);
	}

}
