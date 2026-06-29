package ar.org.proyungas.infrastructure.output.persistence.actionlayer.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.infrastructure.output.persistence.entities.ActionLayer;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionLayerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionLayerMapper {
    ActionLayer toDomain(ActionLayerEntity entity);
    ActionLayerEntity toEntity(ActionLayer domain);
}
