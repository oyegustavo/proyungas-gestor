package ar.org.proyungas.infrastructure.output.persistence.action.get.byfilter;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.VectorialLayer;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.VectorialLayerEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ActionByCriteriaJpaMapper {

    @Mapping(target = "vectorialLayers", source = "vectorialLayers")
    Action toDomain(ActionEntity entity);

    @Mapping(target = "action", ignore = true) // 🚫 break recursion here
    VectorialLayer toDomain(VectorialLayerEntity entity);
}

