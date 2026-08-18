package ar.org.proyungas.infrastructure.output.persistence.layerstatushistory.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.org.proyungas.infrastructure.output.persistence.entities.LayerStatusHistoryEntity;

public interface LayerStatusHistoryRepository extends JpaRepository<LayerStatusHistoryEntity, UUID>{

}
