package ar.org.proyungas.infrastructure.input.action.getbyplantype;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.action.get.byplantype.ActionByPlanTypeFinder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/action/plan-type/{id}")
@Slf4j
@AllArgsConstructor
public class ActionGetByPlanTypeRestAdapter {

	private final ActionByPlanTypeFinder finder;
	private final ActionByPlanTypeRestMapper mapper;

	@Operation(summary = "Action by Plan Type", tags = "Action")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Data sent ok"),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
			@ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
			@ApiResponse(responseCode = "500", description = "Internal Error", content = @Content),
			@ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content) })
	@GetMapping
	public ResponseEntity<List<ActionByPlanTypeResponse>> perform(@PathVariable UUID id) {
		log.info("Calling GET /action/plan-type/{id} - p: {}", id);
		return ResponseEntity.ok(mapper.toResponse(finder.perform(id)));
	}
}
