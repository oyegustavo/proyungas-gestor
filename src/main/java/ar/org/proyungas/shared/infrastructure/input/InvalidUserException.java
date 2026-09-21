package ar.org.proyungas.shared.infrastructure.input;


public class InvalidUserException extends GenericException{
	public InvalidUserException(ErrorCode errorCode) {
		super(errorCode);
	}

}
