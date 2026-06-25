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
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Action Create", tags = "Action")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content) })

    @PostMapping
    public ResponseEntity<ActionCreateResponse> perform(@RequestBody @Valid ActionCreateRequest request) {
        log.info("Start executing service POST /action - REQUEST: {}", request);
        return new ResponseEntity<>(mapper.toResponse(actionCreate.perform(mapper.toCommand(request))),
                HttpStatus.CREATED);
    }
}
