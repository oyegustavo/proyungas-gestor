package ar.org.proyungas.infrastructure.output.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;

@Repository
public interface PlanTypeRepository extends JpaRepository<PlanTypeEntity, UUID>{
    List<PlanTypeEntity> findByEnabledOrderByGroupAsc(Boolean enabled);
    List<PlanTypeEntity> findByEnabledOrderByGroupDesc(Boolean enabled);
}
