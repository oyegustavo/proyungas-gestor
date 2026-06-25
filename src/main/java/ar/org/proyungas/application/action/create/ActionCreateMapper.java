package ar.org.proyungas.application.action.create;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.Action;

@Mapper
public interface ActionCreateMapper {
    ActionCreateResult toResult(Action action);
    Action toDomain(ActionCreateCommand command);
}
