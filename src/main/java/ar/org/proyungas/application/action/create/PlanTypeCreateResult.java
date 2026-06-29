package ar.org.proyungas.application.action.create;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeCreateResult {
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
