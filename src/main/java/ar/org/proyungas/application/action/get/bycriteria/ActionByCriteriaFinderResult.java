package ar.org.proyungas.application.action.get.bycriteria;

import java.util.Set;
import java.util.UUID;

import ar.org.proyungas.application.plantype.get.bycriteria.VectorialLayerByCriteriaFinderResult;
import ar.org.proyungas.domain.models.PlanType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionByCriteriaFinderResult {
	UUID id;
	String actionNumber;
	PlanType planType;
	String propertyOwner;
	String applicantId;
	String uploadedById;
	String derivativeStatus;
	Set<VectorialLayerByCriteriaFinderResult> vectorialLayers;
}
