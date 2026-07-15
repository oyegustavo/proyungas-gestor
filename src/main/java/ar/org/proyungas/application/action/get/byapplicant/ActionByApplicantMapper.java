package ar.org.proyungas.application.action.get.byapplicant;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.Action;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionByApplicantMapper {
	List<ActionByApplicantResult> toResult(List<Action> action);
}
