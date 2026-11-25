package ar.org.proyungas.application.plantype.get.info;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PlanTypeInfoResult {
	Integer enabledPlanTypeCounter;
	Integer disabledPlanTypeCounter;
	Integer planTypeLayerCounter;
	Integer requiredPlanTypeLayerCounter;
}
