package ar.org.proyungas.infrastructure.input.action.create;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.action.create.ActionCreator;
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
@RequestMapping("/action")
@Slf4j
@AllArgsConstructor
public class ActionCreateRestAdapter {

    private final ActionCreator actionCreate;

    private final ActionCreateRestMapper mapper;

    
    @Operation(
            summary = "Action Create",
            tags = "Action",
            security = @SecurityRequirement(name = "bearerAuth"),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            		content = @Content(
            				schema = @Schema(
            						implementation = ActionCreateRequest.class
            						),
            				examples = {
            						@ExampleObject(
            								value = "{ \"action_number\": \"ACT-2026-001\", \"plan_type\": { \"id\": \"2b1f356f-63ea-425c-8ef4-c672217e6347\" }, \"property_owner\": \"John Doe\", \"applicant\": { \"id\": 1 }, \"uploaded_by\": { \"id\": 1 }, \"derivative_status\": \"PENDING\" }"
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
    public ResponseEntity<ActionCreateResponse> perform(@RequestBody @Valid ActionCreateRequest actionCreateRequest
    		, HttpServletRequest request) {
        log.info("Start executing service POST /action - REQUEST: {}", request);
        return new ResponseEntity<>(mapper.toResponse(actionCreate.perform(mapper.toCommand(actionCreateRequest), request)),
                HttpStatus.CREATED);
    }
}
