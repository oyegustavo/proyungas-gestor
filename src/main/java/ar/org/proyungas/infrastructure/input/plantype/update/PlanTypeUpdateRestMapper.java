package ar.org.proyungas.infrastructure.input.plantype.update;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.plantype.update.PlanTypeUpdateCommand;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeUpdateRestMapper {
	PlanTypeUpdateCommand toCommand(PlanTypeUpdateRequest request);
}
