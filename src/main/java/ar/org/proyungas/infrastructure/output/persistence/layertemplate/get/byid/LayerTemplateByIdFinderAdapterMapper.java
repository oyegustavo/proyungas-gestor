package ar.org.proyungas.infrastructure.output.persistence.layertemplate.get.byid;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.LayerTemplate;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerTemplateEntity;

@Mapper(componentModel = "spring")
public interface LayerTemplateByIdFinderAdapterMapper {
	LayerTemplate toDomain(LayerTemplateEntity entity);
}
