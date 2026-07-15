package ar.org.proyungas.infrastructure.input.action.getbycriteria;

import java.util.UUID;

import ar.org.proyungas.domain.models.PlanType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionByCriteriaGetResponse {
    UUID id;
    String actionNumber;
    PlanType planType;
    String propertyOwner;
    String derivativeStatus;
}
