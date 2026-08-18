package ar.org.proyungas.infrastructure.output.persistence.layerversion.get.byid;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.LayerVersion;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerVersionEntity;

@Mapper(componentModel = "spring")
public interface LayerVersionByIdFinderAdapterMapper {
	LayerVersion toDomain(LayerVersionEntity entity);
}
