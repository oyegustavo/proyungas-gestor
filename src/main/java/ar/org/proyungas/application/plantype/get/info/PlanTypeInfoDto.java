package ar.org.proyungas.application.plantype.get.info;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class PlanTypeInfoDto {
	Integer enabledPlanTypeCounter;
	Integer disabledPlanTypeCounter;
	Integer planTypeLayerCounter;
	Integer requiredPlanTypeLayerCounter;
}
