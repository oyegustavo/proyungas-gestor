package ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.get.byid;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;

@Mapper(componentModel = "spring")
public interface VectorialLayerByIdFinderAdapterMapper {
    VectorialLayer toDomain(VectorialLayerEntity entity);
}