package ar.org.proyungas.infrastructure.output.persistence.plantypehistory.get.byplantype;

import java.util.List;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.PlanTypeHistory;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeHistoryEntity;

@Mapper(componentModel = "spring")
public interface PlanTypeHistoryByPlanTypeFinderAdapterMapper {
	PlanTypeHistory toDomain(PlanTypeHistoryEntity entity);
	List<PlanTypeHistory> toDomain(List<PlanTypeHistoryEntity> entities);
	PlanTypeHistoryEntity toEntity(PlanTypeHistory domain);
	List<PlanTypeHistoryEntity> toEntity(List<PlanTypeHistory> domains);
}
