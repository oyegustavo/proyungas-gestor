package ar.org.proyungas.shared.infrastructure.input;

public class DatabaseConnectionException extends GenericException {
    public DatabaseConnectionException(ErrorCode errorCode) { super(errorCode); }
}
