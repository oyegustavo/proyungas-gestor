package ar.org.proyungas.infrastructure.input.action.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionCreateRequest {
    private String actionNumber;
    private PlanTypeCreateRequest planType;
    private String propertyOwner;
    private String applicantId;
    private String uploadedById;
    private String derivativeStatus;
}
