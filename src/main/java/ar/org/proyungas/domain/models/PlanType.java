package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PlanType {
    UUID id;
    String code;
    String name;
    String group;
    String description;
    Boolean enabled;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
}
