package ar.org.proyungas.infrastructure.input.plantype.create;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.plantype.create.PlanTypeCreator;
import ar.org.proyungas.infrastructure.input.action.create.ActionCreateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/plan-type")
@Slf4j
@AllArgsConstructor
public class PlanTypeCreateRestAdapter {
	
    private final PlanTypeCreator planTypeCreate;

    private final PlanTypeCreateRestMapper mapper;

    @Operation(
    	    summary = "Plan Type Create",
    	    tags = "Plan Type",
    	    security = @SecurityRequirement(name = "bearerAuth"),
    	    requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
    	        content = @Content(
    	            schema = @Schema(implementation = PlanTypeCreateRequest.class),
    	            examples = {
    	                @ExampleObject(
    	                    value = "{ \"code\": \"PMS\", \"name\": \"Plan de Manejo Sostenido\", \"group\": \"Otros Planes\", \"description\": \"description\", \"enabled\": true, \"date_from\": \"2026-07-01T00:00:00\", \"layers\": [{ \"layer_code\": \"id_tecnico\", \"label\": \"nombre visible\", \"required\": true, \"active\": true, \"description\": \"condicion opcional\", \"order\": 1  }] }"
    	                )
    	            }
    	        )
    	    )
    	)

    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content) })

    @PostMapping
    public ResponseEntity<PlanTypeCreateResponse> perform(@RequestBody @Valid PlanTypeCreateRequest planTypeCreateRequest
    		, HttpServletRequest request) {
        log.info("Start executing service POST /plan-type - REQUEST: {}", request);
        return new ResponseEntity<>(mapper.toResponse(planTypeCreate.perform(mapper.toCommand(planTypeCreateRequest), request)),
                HttpStatus.CREATED);
    }
}
