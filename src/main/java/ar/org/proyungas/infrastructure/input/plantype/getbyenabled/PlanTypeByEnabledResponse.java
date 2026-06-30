package ar.org.proyungas.infrastructure.input.plantype.getbyenabled;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeByEnabledResponse {
    UUID id;
    String code;
    String name;
    String group;
    String description;
    Boolean enabled;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
}
