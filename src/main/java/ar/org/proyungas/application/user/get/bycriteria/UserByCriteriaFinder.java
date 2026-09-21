package ar.org.proyungas.application.user.get.bycriteria;

import ar.org.proyungas.shared.infrastructure.utils.PageResult;

public interface UserByCriteriaFinder {
	   PageResult<UserByCriteriaFinderResult> perform(UserByCriteriaFinderQuery query);
}
