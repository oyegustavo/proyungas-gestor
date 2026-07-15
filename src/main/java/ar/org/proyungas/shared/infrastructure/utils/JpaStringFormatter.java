package ar.org.proyungas.shared.infrastructure.utils;



public class JpaStringFormatter implements JpaFormatter {

    @Override
    public Object format(Object value) {
        if (value == null || "null".equalsIgnoreCase(value.toString())) {
            return value;
        }

        return value.toString().trim();
    }
}
