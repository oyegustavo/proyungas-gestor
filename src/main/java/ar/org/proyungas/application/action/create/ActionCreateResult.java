package ar.org.proyungas.application.action.create;

import java.time.LocalDateTime;
import java.util.UUID;

import ar.org.proyungas.domain.models.PlanType;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ActionCreateResult {
    UUID id;
    String actionNumber;
    PlanType planType;
    String propertyOwner;
    UserCreateResult applicant;
    UserCreateResult uploadedBy;
    String derivativeStatus;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime deletedAt;
}
