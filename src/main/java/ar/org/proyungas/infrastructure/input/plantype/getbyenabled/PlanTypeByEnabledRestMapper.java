package ar.org.proyungas.infrastructure.input.plantype.getbyenabled;

import java.util.List;

import org.mapstruct.Mapper;

import ar.org.proyungas.application.plantype.get.byenabled.PlanTypeByEnabledResult;

@Mapper(componentModel = "spring")
public interface PlanTypeByEnabledRestMapper {

	List<PlanTypeByEnabledResponse> toResponse(List<PlanTypeByEnabledResult> response);
}
