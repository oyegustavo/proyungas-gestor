package ar.org.proyungas.infrastructure.output.persistence.repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
    List<ActionEntity> findByApplicantIdOrderByCreatedAtAsc(String applicantId);

    @EntityGraph(attributePaths = {"layers", "emailNotifications", "vectorialLayers"})
    List<ActionEntity> findByApplicantIdOrderByCreatedAtDesc(String applicantId);
}
