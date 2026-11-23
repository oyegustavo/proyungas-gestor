package ar.org.proyungas.infrastructure.output.persistence.plantypehistory.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeHistoryEntity;

public interface PlanTypeHistoryRepository extends JpaRepository<PlanTypeHistoryEntity, UUID>{
	List<PlanTypeHistoryEntity> findByPlanType(PlanTypeEntity entity);
}
