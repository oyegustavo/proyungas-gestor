package ar.org.proyungas.infrastructure.output.persistence.layerversion.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.org.proyungas.infrastructure.output.persistence.entities.LayerVersionEntity;

@Repository
public interface LayerVersionRepository extends JpaRepository<LayerVersionEntity, UUID>{

}
