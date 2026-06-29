package ar.org.proyungas.infrastructure.output.persistence.plantype.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeMapper {
    PlanType toDomain(PlanTypeEntity entity);
    PlanTypeEntity toEntity(PlanType domain);
}
