package ar.org.proyungas.application.action.create;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.User;

@Mapper(componentModel = "spring")
public interface ActionCreateMapper {
    ActionCreateResult toResult(Action action);
    Action toDomain(ActionCreateCommand command);
    
    User toDomain(UserCreateCommand command);
}
