package ar.org.proyungas.application.plantype.get.byid;

import java.time.LocalDate;
import java.time.OffsetDateTime;
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
    LocalDate dateFrom;
    LocalDate dateTo;
    OffsetDateTime createdAt;
    OffsetDateTime updatedAt;
}
