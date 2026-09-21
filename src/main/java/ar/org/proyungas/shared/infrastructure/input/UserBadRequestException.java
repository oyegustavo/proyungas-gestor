package ar.org.proyungas.shared.infrastructure.input;


public class UserBadRequestException extends GenericException{

	public UserBadRequestException(ErrorCode errorCode) {
		super(errorCode);
	}

}
