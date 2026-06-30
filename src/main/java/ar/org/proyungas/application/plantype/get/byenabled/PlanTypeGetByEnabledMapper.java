package ar.org.proyungas.application.plantype.get.byenabled;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.PlanType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeGetByEnabledMapper {

	PlanType toDomain(PlanTypeGetByEnabledCommand command);
	
	List<PlanTypeByEnabledResult> toResult(List<PlanType> planTypes);
	
	
}
