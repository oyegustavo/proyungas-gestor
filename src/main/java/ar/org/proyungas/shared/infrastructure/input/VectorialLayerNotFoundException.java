package ar.org.proyungas.shared.infrastructure.input;

public class VectorialLayerNotFoundException extends GenericException{
	public VectorialLayerNotFoundException(ErrorCode errorCode) {
		super(errorCode);
	}
}
