package ar.org.proyungas.shared.infrastructure.input;

public class PlanTypeNotFoundException extends GenericException{
	public PlanTypeNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

}
