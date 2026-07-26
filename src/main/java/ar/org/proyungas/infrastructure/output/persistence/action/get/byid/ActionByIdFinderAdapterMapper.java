package ar.org.proyungas.infrastructure.output.persistence.action.get.byid;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;

@Mapper(componentModel = "spring")
public interface ActionByIdFinderAdapterMapper {
	Action toDomain(ActionEntity entity);
}
