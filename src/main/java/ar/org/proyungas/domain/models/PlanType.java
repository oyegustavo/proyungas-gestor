package ar.org.proyungas.domain.models;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PlanType {
    private UUID id;
    private String code;
    private String name;
    private String group;
    private String description;
    private Boolean enabled;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
}
