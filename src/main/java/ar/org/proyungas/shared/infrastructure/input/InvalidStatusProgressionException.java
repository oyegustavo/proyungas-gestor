package ar.org.proyungas.shared.infrastructure.input;

public class InvalidStatusProgressionException extends GenericException{
	public InvalidStatusProgressionException(ErrorCode errorCode) {
		super(errorCode);
	}

}
