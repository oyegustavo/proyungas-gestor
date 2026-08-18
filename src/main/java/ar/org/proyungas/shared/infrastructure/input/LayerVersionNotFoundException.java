package ar.org.proyungas.shared.infrastructure.input;

public class LayerVersionNotFoundException extends GenericException{
	public LayerVersionNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

}
