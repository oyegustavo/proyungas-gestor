package ar.org.proyungas.shared.infrastructure.input;

public class ActionNotFoundException extends GenericException{
	public ActionNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

}
