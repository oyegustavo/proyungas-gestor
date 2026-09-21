package ar.org.proyungas.domain.output.user;


import java.util.List;

import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.shared.infrastructure.utils.Filter;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;


public interface UserByCriteriaFinderOutputPort {
	 PageDomain<User> perform(Integer page, Integer size, List<Filter> filters);
}