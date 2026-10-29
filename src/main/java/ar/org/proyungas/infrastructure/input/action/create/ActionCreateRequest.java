package ar.org.proyungas.infrastructure.input.action.create;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionCreateRequest {
	@Schema(example = "ACT-2026-001")
    @JsonProperty("action_number")
    private String actionNumber;
    @JsonProperty("plan_type")
    private PlanTypeCreateRequest planType;
    @Schema(example = "John Doe")
    @JsonProperty("property_owner")
    private String propertyOwner;
    private UserRequest applicant;
    @JsonProperty("uploaded_by")
    private UserRequest uploadedBy;
    @Schema(example = "PENDING")
    @JsonProperty("derivative_status")
    private String derivativeStatus;
}
