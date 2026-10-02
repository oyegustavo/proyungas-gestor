package ar.org.proyungas.infrastructure.output.persistence.plantype.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.org.proyungas.infrastructure.output.persistence.entities.PlanTypeEntity;

@Repository
public interface PlanTypeRepository extends JpaRepository<PlanTypeEntity, UUID>{
    Page<PlanTypeEntity> findAll(Specification<PlanTypeEntity> specification, Pageable pageable);
    List<PlanTypeEntity> findByEnabledOrderByGroupAsc(Boolean enabled);
    List<PlanTypeEntity> findByEnabledOrderByGroupDesc(Boolean enabled);
}
