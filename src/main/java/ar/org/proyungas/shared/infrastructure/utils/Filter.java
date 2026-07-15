package ar.org.proyungas.shared.infrastructure.utils;



import java.util.List;

public interface Filter {
    Filter build(String key, List<String> values);
    String getValue();
    String getKey();
}
