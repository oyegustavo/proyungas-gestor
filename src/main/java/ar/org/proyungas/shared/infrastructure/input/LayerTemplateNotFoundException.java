package ar.org.proyungas.shared.infrastructure.input;

public class LayerTemplateNotFoundException extends GenericException{
	public LayerTemplateNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}

}
