package ar.org.proyungas.shared.infrastructure.input;

public class ActionBadRequestException extends GenericException{
	public ActionBadRequestException(ErrorCode errorCode) {
		super(errorCode);
	}

}
