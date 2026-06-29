package ar.org.proyungas.domain.models;

import java.util.List;
import java.util.UUID;

import ar.org.proyungas.infrastructure.output.persistence.entities.ActionLayer;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Action {
	UUID id;
	String actionNumber;
	PlanType planType;
	String propertyOwner;
	String applicantId;
	String uploadedById;
	String derivativeStatus;
	List<ActionLayer> layers;
	List<EmailNotification> emailNotifications;
	List<VectorialLayer> vectorialLayers;
}
