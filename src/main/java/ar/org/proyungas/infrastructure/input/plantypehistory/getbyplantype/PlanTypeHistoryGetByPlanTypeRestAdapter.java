package ar.org.proyungas.infrastructure.input.plantypehistory.getbyplantype;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.layertemplate.create.PlanTypeCommand;
import ar.org.proyungas.application.plantypehistory.get.byplantype.PlanTypeHistoryByPlanTypeFinder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/plan-type-history/plan-type/{id}")
@Slf4j
@AllArgsConstructor
public class PlanTypeHistoryGetByPlanTypeRestAdapter {
	
    private final PlanTypeHistoryByPlanTypeFinder finder;
    private final PlanTypeHistoryByPlanTypeRestMapper mapper;

    @Operation(summary = "Plan Type History", tags = "Plan Type History")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Data sent ok"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content) })
    @GetMapping
    public ResponseEntity<List<PlanTypeHistoryByPlanTypeResponse>> perform(@PathVariable UUID id) {
        log.info("Calling GET /plan-type-history/plan-type with ID - {}", id);
        return ResponseEntity
                .ok(mapper.toResponse(finder.perform(PlanTypeCommand.builder().id(id).build())));
    }

}
