package ar.org.proyungas.shared.infrastructure.input;


public class InvalidFilterTypeException extends GenericException {
    public InvalidFilterTypeException(ErrorCode errorCode) { super(errorCode); }
}

