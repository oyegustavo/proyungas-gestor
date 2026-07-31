package ar.org.proyungas.shared.infrastructure.input;

public class AuditLogBadRequestException extends GenericException{
	public AuditLogBadRequestException(ErrorCode errorCode) {
		super(errorCode);
	}

}
