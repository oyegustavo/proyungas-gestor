package ar.org.proyungas.infrastructure.output.persistence.action.repository;


import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;

@Repository
public interface ActionRepository extends JpaRepository<ActionEntity, UUID>{

    @EntityGraph(attributePaths = {"layers", "emailNotifications", "vectorialLayers"})
    Optional<ActionEntity> findById(UUID id);
    
    @EntityGraph(attributePaths = {"layers", "emailNotifications", "vectorialLayers"})
    Optional<ActionEntity> findByActionNumber(String actionNumber);
    
    @EntityGraph(attributePaths = {"layers", "emailNotifications", "vectorialLayers"})
    Page<ActionEntity> findByApplicantOrderByCreatedAtAsc(String applicant, Pageable pageable);

    @EntityGraph(attributePaths = {"layers", "emailNotifications", "vectorialLayers"})
    Page<ActionEntity> findByApplicantOrderByCreatedAtDesc(String applicant, Pageable pageable);

    Page<ActionEntity> findAll(Specification<ActionEntity> specification, Pageable pageable);
}
