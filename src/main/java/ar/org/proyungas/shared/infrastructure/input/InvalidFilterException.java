package ar.org.proyungas.shared.infrastructure.input;


public class InvalidFilterException extends GenericException {
    public InvalidFilterException(ErrorCode errorCode) { super(errorCode); }
}
