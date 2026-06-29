package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
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
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
