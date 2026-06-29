package ar.org.proyungas.application.action.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActionCreateCommand {
    private String actionNumber;
    private PlanTypeCreateCommand planType;
    private String propertyOwner;
    private String applicantId;
    private String uploadedById;
    private String derivativeStatus;
}
