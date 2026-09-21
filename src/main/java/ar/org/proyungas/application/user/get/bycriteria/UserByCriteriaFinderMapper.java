package ar.org.proyungas.application.user.get.bycriteria;


import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.shared.infrastructure.utils.PageDomain;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;


@Mapper(componentModel = "spring")
public interface UserByCriteriaFinderMapper {
	
	UserByCriteriaFinderResult toResult(User user);
	
	PageResult<UserByCriteriaFinderResult> toResult(PageDomain<User> domain);

}
