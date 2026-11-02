package ar.org.proyungas.shared.infrastructure.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JpaEqualsFilter implements JpaFilter {

    private String field;
    private Object value;

    @Override
    public <T> Specification<T> getSpecification() {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            Path<?> path = root;
            // 🔑 Traverse nested fields like "applicant.id"
            for (String part : field.split("\\.")) {
                path = path.get(part);
            }

            // Defensive logging (optional)
            // System.out.println("Comparing field: " + field + " with value: " + value + " (" + value.getClass() + ")");

            return cb.equal(path, value);
        };
    }

    @Override
    public JpaFilter fromDomain(Filter domain) {
        EqualsFilter equalsFilter = (EqualsFilter) domain;
        Object typedValue = equalsFilter.getValue();

        // Convert string values to proper types based on field
        if ("enabled".equals(equalsFilter.getKey())) {
            typedValue = Boolean.valueOf(String.valueOf(typedValue));
        }
        if ("applicant".equals(equalsFilter.getKey())) {
            // Ensure applicant values are parsed as Integer
            typedValue = Integer.valueOf(String.valueOf(typedValue));
        }

        return JpaEqualsFilter.builder()
                .field(equalsFilter.getKey())   // will be translated later
                .value(typedValue)
                .build();
    }

    @Override
    public JpaFilter formatValues(Map<String, JpaFormatter> formatters) {
        if (formatters.containsKey(field)) {
            JpaFormatter formatter = formatters.get(field);
            Object formattedValue = formatter.format(value);
            this.setValue(formattedValue);
        }
        return this;
    }

    @Override
    public JpaFilter translateField(Map<String, String> translations) {
        if (translations.containsKey(field)) {
            String translatedField = translations.get(field);
            this.setField(translatedField);
        }
        return this;
    }
}
