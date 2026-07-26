package ar.org.proyungas.infrastructure.input.vectoriallayer.update;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.vectoriallayer.update.VectorialLayerUpdater;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vectorial-layer/{id}")
@Slf4j
@AllArgsConstructor
public class VectorialLayerUpdateRestAdapter {
	
    private final VectorialLayerUpdater vectorialLayerUpdater;

    private final VectorialLayerUpdateRestMapper vectorialLayerUpdateRestMapper;

    @Operation(summary = "Vectorial Layer Update", tags = "Vectorial Layer")
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
            @PathVariable UUID id,
            @RequestBody @Valid VectorialLayerUpdateRequest vectorialLayerUpdateRequest,
            HttpServletRequest request) {
    	
        log.info("Starting executing service PUT /vectorial-layer/{id} - REQUEST: {}",
        		id, vectorialLayerUpdateRequest);

        vectorialLayerUpdater.perform(
        		vectorialLayerUpdateRestMapper.toCommand(vectorialLayerUpdateRequest), id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
