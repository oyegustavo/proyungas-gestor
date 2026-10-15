package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
@With
public class PlanType {
    UUID id;
    String code;
    String name;
    String group;
    String description;
    Boolean enabled;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
    List<LayerTemplate> layers;
}
