package ar.org.proyungas.infrastructure.output.persistence.plantypehistory.create;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.PlanTypeHistory;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeHistoryEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlanTypeHistoryMapper {
	PlanTypeHistoryEntity toEntity(PlanTypeHistory domain);
	List<PlanTypeHistoryEntity> toEntity(List<PlanTypeHistory> domains);
	PlanTypeHistory toDomain(PlanTypeHistoryEntity entity);
	List<PlanTypeHistory> toDomain(List<PlanTypeHistoryEntity> entities);
}
