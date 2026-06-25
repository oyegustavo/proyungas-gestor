package ar.org.proyungas.domain.models;

import java.time.OffsetDateTime;
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
    User applicant;
    User uploadedBy;
    String derivativeStatus;
    OffsetDateTime createdAt;
    OffsetDateTime updatedAt;
    OffsetDateTime deletedAt;
}
