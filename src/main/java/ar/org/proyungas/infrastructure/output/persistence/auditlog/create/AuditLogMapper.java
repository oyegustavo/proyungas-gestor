package ar.org.proyungas.infrastructure.output.persistence.auditlog.create;

import org.mapstruct.Mapper;

import ar.org.proyungas.domain.models.AuditLog;
import ar.org.proyungas.infrastructure.output.persistence.entities.AuditLogEntity;

@Mapper(componentModel = "spring")
public interface AuditLogMapper {
	AuditLogEntity toEntity(AuditLog auditLog);
	AuditLog toDomain(AuditLogEntity entity);
}
