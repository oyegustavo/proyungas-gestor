package ar.org.proyungas.shared.infrastructure.utils;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;


@Value
@Builder
@AllArgsConstructor
public class ContainsFilter implements Filter {
    String key;
    String value;

    public ContainsFilter() {
        key = null;
        value = null;
    }

    @Override
    public Filter build(String key, List<String> values) {
        return new ContainsFilterBuilder()
                .key(key)
                .value(values == null || values.isEmpty() ? null : values.get(0))
                .build();
    }
}
