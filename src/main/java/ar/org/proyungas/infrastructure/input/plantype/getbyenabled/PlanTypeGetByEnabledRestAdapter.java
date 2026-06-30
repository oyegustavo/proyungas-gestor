package ar.org.proyungas.infrastructure.input.plantype.getbyenabled;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.plantype.get.byenabled.PlanTypeByEnabledFinder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/plan-type")
@Slf4j
@AllArgsConstructor
public class PlanTypeGetByEnabledRestAdapter {
    private final PlanTypeByEnabledFinder finder;
    private final PlanTypeByEnabledRestMapper mapper;

    @Operation(summary = "Plan Types", tags = "Plan Type")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Data sent ok"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content) })
    @GetMapping
    public ResponseEntity<List<PlanTypeByEnabledResponse>> perform() {
        log.info("Calling GET /plan-type");

        return ResponseEntity
                .ok(mapper.toResponse(finder.perform(true)));
    }
}
