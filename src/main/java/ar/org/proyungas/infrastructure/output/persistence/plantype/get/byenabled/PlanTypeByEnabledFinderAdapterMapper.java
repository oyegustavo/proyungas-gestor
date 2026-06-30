package ar.org.proyungas.infrastructure.output.persistence.plantype.get.byenabled;

import java.util.List;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;

@Mapper(componentModel = "spring")
public interface PlanTypeByEnabledFinderAdapterMapper {
	PlanType toDomain(PlanTypeEntity entity);
	List<PlanType> toDomain(List<PlanTypeEntity> entities);
}
