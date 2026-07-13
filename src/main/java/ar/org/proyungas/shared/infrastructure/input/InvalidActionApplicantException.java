package ar.org.proyungas.shared.infrastructure.input;

public class InvalidActionApplicantException extends GenericException{
	public InvalidActionApplicantException(ErrorCode errorCode) {
		super(errorCode);
	}

}
