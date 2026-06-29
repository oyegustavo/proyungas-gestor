package ar.org.proyungas.application.plantype.get.byid;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeByIdFinderResult {
    UUID id;
    String code;
    String name;
    String group;
    String description;
    Boolean enabled;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
