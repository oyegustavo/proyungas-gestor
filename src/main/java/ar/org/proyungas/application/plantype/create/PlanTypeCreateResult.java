package ar.org.proyungas.application.plantype.create;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeCreateResult {
    String code;
    String name;
    String group;
    String description;
    Boolean enabled;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
    List<LayerTemplateResult> layers;
}
