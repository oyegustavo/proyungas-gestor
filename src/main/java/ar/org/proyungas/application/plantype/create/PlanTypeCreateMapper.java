package ar.org.proyungas.application.plantype.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.PlanType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeCreateMapper {
    PlanTypeCreateResult toResult(PlanType planType);
    PlanType toDomain(PlanTypeCreateCommand command);
}
