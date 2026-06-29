package ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VectorialLayerMapper {
    VectorialLayer toDomain(VectorialLayerEntity entity);
    VectorialLayerEntity toEntity(VectorialLayer domain);
}
