package ar.org.proyungas.domain.output.action;

import ar.org.proyungas.domain.models.AuditLog;

public interface AuditLogOutputPort {
	void perform(AuditLog auditLog);
}
