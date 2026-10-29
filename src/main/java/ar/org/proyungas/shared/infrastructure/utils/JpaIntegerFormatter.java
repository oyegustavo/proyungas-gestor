package ar.org.proyungas.shared.infrastructure.utils;


public class JpaIntegerFormatter implements JpaFormatter {

    @Override
    public Object format(Object value) {
        if (value == null) {
            return null;
        }
        if (value instanceof Integer) {
            return value;
        }
        return Integer.valueOf(value.toString());
    }
}
