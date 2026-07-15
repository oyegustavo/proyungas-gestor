package ar.org.proyungas.shared.infrastructure.utils;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;


import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
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
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
                -> criteriaBuilder.equal(JpaFilterUtils.getExpression(field, root), value);
    }

    @Override
    public JpaFilter fromDomain(Filter domain) {
        EqualsFilter equalsFilter = (EqualsFilter) domain;
        Object typedValue = equalsFilter.getValue();

        // Convert string values to proper types based on field
        if ("enabled".equals(equalsFilter.getKey())) {
            typedValue = Boolean.valueOf(String.valueOf(typedValue));
        }
        // You can add more conversions here for other fields (e.g. Integer, Long, etc.)

        return JpaEqualsFilter.builder()
                .field(equalsFilter.getKey())   // must be the entity property name
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
