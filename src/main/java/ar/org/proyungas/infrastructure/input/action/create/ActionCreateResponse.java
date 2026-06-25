package ar.org.proyungas.infrastructure.input.action.create;

import java.util.UUID;

import ar.org.proyungas.domain.models.PlanType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionCreateResponse {
    UUID id;
    String actionNumber;
    PlanType planType;
    String propertyOwner;
    UserCreateResponse applicant;
    UserCreateResponse uploadedBy;
    String derivativeStatus;
}
