package ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.create;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
implementationName = "VectorialLayerMapperImpl",
uses = { /* other mappers */ })
@DecoratedWith(VectorialLayerMapperDecorator.class)
public interface VectorialLayerMapper {
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    VectorialLayerEntity toEntity(VectorialLayer domain);
    VectorialLayer toDomain(VectorialLayerEntity entity);
}

