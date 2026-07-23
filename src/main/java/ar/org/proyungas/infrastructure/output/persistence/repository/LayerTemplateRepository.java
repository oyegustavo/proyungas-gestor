package ar.org.proyungas.infrastructure.output.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.org.proyungas.infrastructure.output.persistence.entities.LayerTemplateEntity;

@Repository
public interface LayerTemplateRepository extends JpaRepository<LayerTemplateEntity, UUID>{

}
