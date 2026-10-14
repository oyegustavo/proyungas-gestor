package ar.org.proyungas.shared.infrastructure.input;

public class PlanTypeBadRequestException extends GenericException{
	public PlanTypeBadRequestException(ErrorCode errorCode) {
		super(errorCode);
	}

}
