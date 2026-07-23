package ar.org.proyungas.shared.infrastructure.input;

public class VectorialLayerBadRequestException extends GenericException{
	public VectorialLayerBadRequestException(ErrorCode errorCode) {
		super(errorCode);
	}

}
