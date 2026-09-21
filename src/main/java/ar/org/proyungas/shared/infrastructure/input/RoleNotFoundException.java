package ar.org.proyungas.shared.infrastructure.input;


public class RoleNotFoundException extends GenericException{

	public RoleNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

}
