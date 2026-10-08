package ar.org.proyungas.infrastructure.input.layertemplate.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.application.layertemplate.create.LayerTemplateCreateCommand;
import ar.org.proyungas.application.layertemplate.create.LayerTemplateCreateResult;
import ar.org.proyungas.infrastructure.input.vectoriallayer.create.LayerTemplateCreateResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LayerTemplateCreateRestMapper {
	LayerTemplateCreateCommand toCommand(LayerTemplateCreateRequest request);
	LayerTemplateCreateResponse toResponse(LayerTemplateCreateResult result);
}
