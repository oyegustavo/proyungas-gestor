package ar.org.proyungas.application.plantype.get.bycriteria;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.output.plantype.PlanTypeByCriteriaFinderOutputPort;
import ar.org.proyungas.shared.infrastructure.utils.Filter;
import ar.org.proyungas.shared.infrastructure.utils.FilterBuilder;
import ar.org.proyungas.shared.infrastructure.utils.FilterUtils;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PlanTypeByCriteriaFinderUseCase implements PlanTypeByCriteriaFinder{
	
    private final PlanTypeByCriteriaFinderOutputPort outputPort;
    private final PlanTypeByCriteriaFinderMapper mapper;

    private static final List<String> ALLOWED_FILTERS =
            Collections.unmodifiableList(Arrays.asList("name", "group", "enabled"));
	
	@Override
	public PageResult<PlanTypeByCriteriaFinderResult> perform(PlanTypeByCriteriaFinderQuery query) {
		
        FilterUtils.validateFiltersMap(query.getFilters(), ALLOWED_FILTERS);

        List<Filter> filters = new FilterBuilder().build(query.getFilters());

        PageDomain<PlanType> userPage = outputPort.perform(query.getPage(), query.getSize(), filters);

        return mapper.toResult(userPage);
	}
}
