package ar.org.proyungas.shared.infrastructure.input;


public class MalformedFilterException extends GenericException {
    public MalformedFilterException(ErrorCode errorCode) { super(errorCode); }
}
