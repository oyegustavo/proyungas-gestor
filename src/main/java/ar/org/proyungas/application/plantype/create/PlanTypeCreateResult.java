package ar.org.proyungas.application.plantype.create;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeCreateResult {
	UUID id;
    String code;
    String name;
    String group;
    String description;
    Boolean enabled;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
    List<LayerTemplateResult> layers;
}
