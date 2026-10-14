package ar.org.proyungas.infrastructure.input.action.create;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ActionCreateRequest {
	@Schema(example = "ACT-2026-001")
    private String actionNumber;
    private PlanTypeCreateRequest planType;
    @Schema(example = "John Doe")
    private String propertyOwner;
    private UserRequest applicant;
    private UserRequest uploadedBy;
    @Schema(example = "PENDING")
    private String derivativeStatus;
}
