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
public class JpaContainsFilter implements JpaFilter {

    private String field;
    private Object value;

    @Override
    public <T> Specification<T> getSpecification() {
        return (Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
                -> criteriaBuilder.like(criteriaBuilder.upper(JpaFilterUtils.getExpression(field, root)),
                "%" + value.toString().toUpperCase() + "%");
    }

    @Override
    public JpaFilter fromDomain(Filter domain) {
        ContainsFilter filter = (ContainsFilter) domain;

        return new JpaContainsFilterBuilder()
                .field(filter.getKey())
                .value(filter.getValue())
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

