package ar.org.proyungas.application.layertemplate.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.LayerTemplate;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LayerTemplateCreateMapper {
    LayerTemplateCreateResult toResult(LayerTemplate layerTemplate);
    LayerTemplate toDomain(LayerTemplateCreateCommand command);
}
