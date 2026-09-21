package ar.org.proyungas.infrastructure.input.user.getbycriteria;


import org.mapstruct.Mapper;

import ar.org.proyungas.application.user.get.bycriteria.UserByCriteriaFinderResult;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;


@Mapper(componentModel = "spring")
public interface UserByCriteriaGetMapper {
    PageResult<UserByCriteriaGetResponse> toResponse(PageResult<UserByCriteriaFinderResult> results);
}
