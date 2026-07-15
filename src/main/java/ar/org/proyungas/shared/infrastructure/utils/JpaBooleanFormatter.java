package ar.org.proyungas.shared.infrastructure.utils;


public class JpaBooleanFormatter implements JpaFormatter{

	@Override
	public Object format(Object value) {
        if (value == null || "null".equalsIgnoreCase(value.toString())) {
            return value;
        }

        return Boolean.valueOf(value.toString());
	}

}
