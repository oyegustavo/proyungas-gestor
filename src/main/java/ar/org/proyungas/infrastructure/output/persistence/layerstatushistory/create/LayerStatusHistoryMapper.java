package ar.org.proyungas.infrastructure.output.persistence.layerstatushistory.create;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.LayerStatusHistory;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerStatusHistoryEntity;

@Mapper(componentModel = "spring")
public interface LayerStatusHistoryMapper {
	LayerStatusHistory toDomain(LayerStatusHistoryEntity entity);
	LayerStatusHistoryEntity toEntity(LayerStatusHistory layerStatusHistory);
}
