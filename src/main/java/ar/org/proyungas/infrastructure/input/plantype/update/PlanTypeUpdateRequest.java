package ar.org.proyungas.infrastructure.input.plantype.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanTypeUpdateRequest {
    String name;
    Boolean enabled;
}
