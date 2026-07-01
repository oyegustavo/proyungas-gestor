package ar.org.proyungas.application.action.get.byactionnumber;

import java.util.UUID;

import ar.org.proyungas.domain.models.PlanType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionByActionNumberResult {
	UUID id;
	String actionNumber;
	PlanType planType;
	String propertyOwner;
	String applicantId;
	String uploadedById;
	String derivativeStatus;
}
