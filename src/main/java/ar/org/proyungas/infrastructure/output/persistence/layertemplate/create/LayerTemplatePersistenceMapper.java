package ar.org.proyungas.infrastructure.output.persistence.layertemplate.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerTemplateEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LayerTemplatePersistenceMapper {
    LayerTemplate toDomain(LayerTemplateEntity entity);
    LayerTemplateEntity toEntity(LayerTemplate domain);
}
