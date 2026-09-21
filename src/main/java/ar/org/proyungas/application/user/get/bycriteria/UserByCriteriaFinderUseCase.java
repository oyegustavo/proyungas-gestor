package ar.org.proyungas.application.user.get.bycriteria;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.domain.output.user.UserByCriteriaFinderOutputPort;
import ar.org.proyungas.shared.infrastructure.utils.Filter;
import ar.org.proyungas.shared.infrastructure.utils.FilterBuilder;
import ar.org.proyungas.shared.infrastructure.utils.FilterUtils;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserByCriteriaFinderUseCase implements UserByCriteriaFinder{

    private final UserByCriteriaFinderOutputPort userByCriteriaFinderOutputPort;
    private final UserByCriteriaFinderMapper mapper;

    private static final List<String> ALLOWED_FILTERS =
            Collections.unmodifiableList(Arrays.asList("username", "fullname", "enabled"));
	
	@Override
	public PageResult<UserByCriteriaFinderResult> perform(UserByCriteriaFinderQuery query) {
		
        FilterUtils.validateFiltersMap(query.getFilters(), ALLOWED_FILTERS);

        List<Filter> filters = new FilterBuilder().build(query.getFilters());

        PageDomain<User> userPage = userByCriteriaFinderOutputPort.perform(query.getPage(), query.getSize(), filters);

        return mapper.toResult(userPage);
	}

}
