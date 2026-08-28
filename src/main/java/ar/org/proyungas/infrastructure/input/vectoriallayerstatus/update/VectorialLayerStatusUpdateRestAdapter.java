package ar.org.proyungas.infrastructure.input.vectoriallayerstatus.update;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.vectoriallayer.updatestatus.VectorialLayerStatusUpdater;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vectorial-layer-status/{vectorialLayerId}")
@Slf4j
@AllArgsConstructor
public class VectorialLayerStatusUpdateRestAdapter {
	
    private final VectorialLayerStatusUpdater vectorialLayerStatusUpdater;

    private final VectorialLayerStatusUpdateMapper vectorialLayerStatusUpdateMapper;

    @Operation(summary = "Vectorial Layer Status Update", tags = "Vectorial Layer Status")
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
            @PathVariable String vectorialLayerId,
            @RequestBody @Valid VectorialLayerStatusUpdateRequest vectorialLayerStatusUpdateRequest,
            HttpServletRequest request) {
        log.info("Started executing service PUT /vectorial-layer-status/{vectorialLayerId} - REQUEST: {}", vectorialLayerId, vectorialLayerStatusUpdateRequest);

        vectorialLayerStatusUpdater.perform(vectorialLayerStatusUpdateMapper.toCommand(vectorialLayerStatusUpdateRequest), UUID.fromString(vectorialLayerId), request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
