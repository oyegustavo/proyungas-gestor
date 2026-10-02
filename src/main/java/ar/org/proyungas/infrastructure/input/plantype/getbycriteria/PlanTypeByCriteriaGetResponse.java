package ar.org.proyungas.infrastructure.input.plantype.getbycriteria;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import ar.org.proyungas.infrastructure.input.plantype.create.LayerTemplateResponse;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeByCriteriaGetResponse {
    UUID id;
    String code;
    String name;
    String group;
    String description;
    Boolean enabled;
    LocalDateTime dateFrom;
    LocalDateTime dateTo;
    List<LayerTemplateResponse> layers;
}
