package ar.org.proyungas.application.plantypehistory.get.byplantype;

import java.time.LocalDateTime;
import java.util.UUID;

import ar.org.proyungas.application.action.get.byactionnumber.UserResult;
import ar.org.proyungas.application.layertemplate.create.PlanTypeResult;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PlanTypeHistoryByPlanTypeResult {
    UUID id;
    PlanTypeResult planType;
    UserResult user;
    String action;
    String comments;
    String previousData;
    LocalDateTime createdAt;
}
