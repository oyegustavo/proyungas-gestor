package ar.org.proyungas.infrastructure.output.persistence.plantype.get.bycriteria;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;

@Mapper(componentModel = "spring")
public interface PlanTypeByCriteriaJpaMapper {
	PlanType toDomain(PlanTypeEntity entity);
}
