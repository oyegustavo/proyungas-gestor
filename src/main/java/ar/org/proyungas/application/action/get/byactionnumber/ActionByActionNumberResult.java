package ar.org.proyungas.application.action.get.byactionnumber;

import java.util.Set;
import java.util.UUID;

import ar.org.proyungas.application.layertemplate.create.PlanTypeResult;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionByActionNumberResult {
	UUID id;
	String actionNumber;
	PlanTypeResult planType;
	String propertyOwner;
	String applicantId;
	String uploadedById;
	String derivativeStatus;
	Set<VectorialLayerResult> vectorialLayers;
}
