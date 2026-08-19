package ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.org.proyungas.infrastructure.output.persistence.entities.EmailNotificationEntity;

@Repository
public interface EmailNotificationRepository extends JpaRepository<EmailNotificationEntity, UUID>{

}
