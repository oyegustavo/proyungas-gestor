package ar.org.proyungas.infrastructure.input.plantypehistory.getbyplantype;

import java.time.LocalDateTime;
import java.util.UUID;

import ar.org.proyungas.infrastructure.input.action.getbyactionnumber.PlanTypeResponse;
import ar.org.proyungas.infrastructure.input.plantype.create.UserResponse;
import lombok.Builder;
import lombok.Value;
import lombok.With;

@Builder
@Value
@With
public class PlanTypeHistoryByPlanTypeResponse {
    UUID id;
    PlanTypeResponse planType;
    UserResponse user;
    String action;
    String comments;
    String previousData;
    LocalDateTime createdAt;
}
