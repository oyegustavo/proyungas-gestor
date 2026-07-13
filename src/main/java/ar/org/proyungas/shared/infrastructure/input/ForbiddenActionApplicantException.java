package ar.org.proyungas.shared.infrastructure.input;

public class ForbiddenActionApplicantException extends GenericException{
	public ForbiddenActionApplicantException(ErrorCode errorCode) {
		super(errorCode);
	}

}
