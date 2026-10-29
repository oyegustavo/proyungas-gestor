package ar.org.proyungas.domain.models;

import java.util.Set;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
public class Action {
	UUID id;
	String actionNumber;
	PlanType planType;
	String propertyOwner;
	@With
	User applicant;
	@With
	User uploadedBy;
	@With
	String derivativeStatus;
	Set<VectorialLayer> vectorialLayers;
	Set<EmailNotification> emailNotifications;
}
