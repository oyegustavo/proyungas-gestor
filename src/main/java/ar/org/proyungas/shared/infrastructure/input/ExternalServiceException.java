package ar.org.proyungas.shared.infrastructure.input;

public class ExternalServiceException extends GenericException {
    public ExternalServiceException(ErrorCode errorCode) { super(errorCode); }
}
