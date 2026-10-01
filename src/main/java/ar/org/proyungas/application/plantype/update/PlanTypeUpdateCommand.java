package ar.org.proyungas.application.plantype.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanTypeUpdateCommand {
    String name;
    Boolean enabled;
}
