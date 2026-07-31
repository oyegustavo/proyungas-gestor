package ar.org.proyungas.shared.infrastructure.input;

public class JsonSerializerException extends GenericException{
	public JsonSerializerException(ErrorCode errorCode) {
		super(errorCode);
	}
}
