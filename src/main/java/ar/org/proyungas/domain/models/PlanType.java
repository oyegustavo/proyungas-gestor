package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
public class PlanType {
    UUID id;
    String code;
	@With
    String name;
    String group;
    String description;
	@With
    Boolean enabled;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
    List<VectorialLayer> layers;
}
