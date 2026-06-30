package ar.org.proyungas.shared.infrastructure.input;

public class RepeatedActionNumberException extends GenericException{
	public RepeatedActionNumberException(ErrorCode errorCode) {
		super(errorCode);
	}

}
