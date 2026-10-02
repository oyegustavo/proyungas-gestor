package ar.org.proyungas.infrastructure.input.plantype.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.plantype.create.PlanTypeCreateCommand;
import ar.org.proyungas.application.plantype.create.PlanTypeCreateResult;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeCreateRestMapper {
    PlanTypeCreateCommand toCommand(PlanTypeCreateRequest request);
    PlanTypeCreateResponse toResponse(PlanTypeCreateResult result);
}
