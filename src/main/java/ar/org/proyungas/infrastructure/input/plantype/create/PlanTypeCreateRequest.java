package ar.org.proyungas.infrastructure.input.plantype.create;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanTypeCreateRequest {
    String code;
    String name;
    String group;
    String description;
    @Builder.Default
    private Boolean enabled = true;
    @JsonProperty("date_from")
    LocalDateTime dateFrom;
    @JsonProperty("date_to")
    LocalDateTime dateTo;
    List<LayerTemplateRequest> layers;
}
