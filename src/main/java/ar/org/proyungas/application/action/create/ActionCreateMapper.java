package ar.org.proyungas.application.action.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionCreateMapper {
    ActionCreateResult toResult(Action action);
    Action toDomain(ActionCreateCommand command);
    
    User toDomain(UserCreateCommand command);
}
