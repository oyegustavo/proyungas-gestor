package ar.org.proyungas.shared.infrastructure.utils;



import org.springframework.data.jpa.domain.Specification;


import java.util.Map;

public interface JpaFilter {
    <T> Specification<T> getSpecification();
    JpaFilter fromDomain(Filter domain);
    JpaFilter formatValues(Map<String, JpaFormatter> formatters);
    JpaFilter translateField(Map<String, String> translations);
}
