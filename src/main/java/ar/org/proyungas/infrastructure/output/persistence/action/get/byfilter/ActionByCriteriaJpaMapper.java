package ar.org.proyungas.infrastructure.output.persistence.action.get.byfilter;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;

@Mapper(componentModel = "spring")
public interface ActionByCriteriaJpaMapper {
	Action toDomain(ActionEntity entity);
}
