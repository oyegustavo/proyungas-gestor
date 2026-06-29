package ar.org.proyungas.infrastructure.output.persistence.action.create;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;

@Mapper(componentModel = "spring")
public interface ActionPersistenceMapper {
	Action toDomain(ActionEntity entity);
	ActionEntity toEntity(Action action);
}
