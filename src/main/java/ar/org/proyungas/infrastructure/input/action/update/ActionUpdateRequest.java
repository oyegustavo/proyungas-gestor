package ar.org.proyungas.infrastructure.input.action.update;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionUpdateRequest {
	@JsonProperty("applicant-id")
    String applicantId;
	@JsonProperty("uploaded-by-id")
    String uploadedById;
	@JsonProperty("derivative-status")
    String derivativeStatus;
}
