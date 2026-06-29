package ar.org.proyungas.shared.infrastructure.input;

public class UserNotFoundException extends GenericException{
	public UserNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

}
