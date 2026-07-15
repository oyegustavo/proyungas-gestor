package ar.org.proyungas.infrastructure.input.action.getbyapplicant;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.action.get.byapplicant.ActionByApplicantResult;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionByApplicantRestMapper {
	List<ActionByApplicantResponse> toResponse(List<ActionByApplicantResult> result);
}