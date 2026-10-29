package ar.org.proyungas.shared.infrastructure.utils;



import java.util.UUID;

public class JpaUuidFormatter implements JpaFormatter {

    @Override
    public Object format(Object value) {
        if (value == null) {
            return null;
        }
        // Defensive: accept both String and UUID
        if (value instanceof UUID) {
            return value;
        }
        return UUID.fromString(value.toString());
    }
}


