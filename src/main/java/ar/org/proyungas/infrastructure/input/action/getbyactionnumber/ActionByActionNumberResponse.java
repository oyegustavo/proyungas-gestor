package ar.org.proyungas.infrastructure.input.action.getbyactionnumber;

import java.util.UUID;

import ar.org.proyungas.domain.models.PlanType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionByActionNumberResponse {
    UUID id;
    String actionNumber;
    PlanType planType;
    String propertyOwner;
    String derivativeStatus;
}
