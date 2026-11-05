package ar.org.proyungas.infrastructure.input.action.getbyactionnumber;

import java.util.Set;
import java.util.UUID;

import ar.org.proyungas.infrastructure.input.plantype.create.VectorialLayerResponse;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionByActionNumberResponse {
    UUID id;
    String actionNumber;
    PlanTypeResponse planType;
    String propertyOwner;
    String derivativeStatus;
    Set<VectorialLayerResponse> vectorialLayers;
}
