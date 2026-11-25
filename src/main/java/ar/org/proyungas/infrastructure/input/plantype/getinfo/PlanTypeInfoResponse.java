package ar.org.proyungas.infrastructure.input.plantype.getinfo;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeInfoResponse {
	Integer enabledPlanTypeCounter;
	Integer disabledPlanTypeCounter;
	Integer planTypeLayerCounter;
	Integer requiredPlanTypeLayerCounter;
}
