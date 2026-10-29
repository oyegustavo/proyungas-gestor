package ar.org.proyungas.infrastructure.input.action.create;

import java.util.UUID;

import ar.org.proyungas.infrastructure.input.plantype.create.PlanTypeCreateResponse;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionCreateResponse {
    UUID id;
    String actionNumber;
    PlanTypeCreateResponse planType;
    String propertyOwner;
    UserCreateResponse applicant;
    UserCreateResponse uploadedBy;
    String derivativeStatus;
}
