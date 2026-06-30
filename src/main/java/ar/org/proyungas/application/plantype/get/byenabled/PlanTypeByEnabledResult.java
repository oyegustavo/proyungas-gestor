package ar.org.proyungas.application.plantype.get.byenabled;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeByEnabledResult {
    UUID id;
    String code;
    String name;
    String group;
    String description;
    Boolean enabled;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
}
