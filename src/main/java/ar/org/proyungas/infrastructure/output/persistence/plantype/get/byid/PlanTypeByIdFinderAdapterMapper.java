package ar.org.proyungas.infrastructure.output.persistence.plantype.get.byid;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;

@Mapper(componentModel = "spring")
public interface PlanTypeByIdFinderAdapterMapper {
	PlanType toDomain(PlanTypeEntity entity);
}
