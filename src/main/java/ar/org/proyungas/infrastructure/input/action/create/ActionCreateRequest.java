package ar.org.proyungas.infrastructure.input.action.create;

import ar.org.proyungas.application.action.create.PlanTypeCreateCommand;
import ar.org.proyungas.application.action.create.UserCreateCommand;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ActionCreateRequest {
    String actionNumber;
    PlanTypeCreateCommand planType;
    String propertyOwner;
    UserCreateCommand applicant;
    UserCreateCommand uploadedBy;
    String derivativeStatus;
}
