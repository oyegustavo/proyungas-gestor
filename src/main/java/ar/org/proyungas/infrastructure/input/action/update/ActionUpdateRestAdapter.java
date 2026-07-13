package ar.org.proyungas.infrastructure.input.action.update;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.action.update.ActionUpdater;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/action/{actionNumber}")
@Slf4j
@AllArgsConstructor
public class ActionUpdateRestAdapter {

    private final ActionUpdater actionUpdater;

    private final ActionUpdateRestMapper actionUpdateRestMapper;

    @Operation(summary = "Action Update", tags = "Action")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Resource updated"),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content)
    })
    @PutMapping
    public ResponseEntity<Void> perform(
            @PathVariable String actionNumber,
            @RequestBody @Valid ActionUpdateRequest actionUpdateRequest,
            HttpServletRequest request) {
        log.info("Starting executing service PUT /action/{actionNumber} - REQUEST: {}", actionNumber, actionUpdateRequest);

        actionUpdater.perform(actionUpdateRestMapper.toCommand(actionUpdateRequest), actionNumber, request);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
