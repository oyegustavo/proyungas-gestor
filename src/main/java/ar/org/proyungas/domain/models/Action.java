package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

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
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    LocalDateTime deletedAt;
}
