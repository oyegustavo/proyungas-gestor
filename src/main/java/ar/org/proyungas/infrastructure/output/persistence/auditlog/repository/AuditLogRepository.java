package ar.org.proyungas.infrastructure.output.persistence.auditlog.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.org.proyungas.infrastructure.output.persistence.entities.AuditLogEntity;

public interface AuditLogRepository extends JpaRepository<AuditLogEntity, UUID> {
}

