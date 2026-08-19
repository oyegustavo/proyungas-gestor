package ar.org.proyungas.shared.infrastructure.input;

public class EmailNotificationBadRequestException extends GenericException{
	public EmailNotificationBadRequestException(ErrorCode errorCode) {
		super(errorCode);
	}

}
