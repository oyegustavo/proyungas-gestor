package ar.org.proyungas.application.plantype.update;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.PlanType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeUpdateMapper {
    PlanType toDomain(PlanTypeUpdateCommand command);
}
