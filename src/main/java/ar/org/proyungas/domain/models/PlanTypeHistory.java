package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
@With
public class PlanTypeHistory {
    UUID id;
    PlanType planType;
    User user;
    String action;
    String comments;
    String previousData;
    LocalDateTime createdAt;
}
