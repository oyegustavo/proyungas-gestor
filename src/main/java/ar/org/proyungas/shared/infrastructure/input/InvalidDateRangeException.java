package ar.org.proyungas.shared.infrastructure.input;

public class InvalidDateRangeException extends GenericException {
    public InvalidDateRangeException(ErrorCode errorCode) {
        super(errorCode);
    }
}
