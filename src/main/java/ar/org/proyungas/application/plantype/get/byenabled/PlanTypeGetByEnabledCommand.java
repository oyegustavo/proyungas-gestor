package ar.org.proyungas.application.plantype.get.byenabled;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlanTypeGetByEnabledCommand {
	private Boolean enabled;
}
