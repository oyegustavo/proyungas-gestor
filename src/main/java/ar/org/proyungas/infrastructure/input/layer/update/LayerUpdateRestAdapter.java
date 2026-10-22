package ar.org.proyungas.infrastructure.input.layer.update;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.layer.update.LayerUpdateDomainService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/layer")
@Slf4j
@AllArgsConstructor
public class LayerUpdateRestAdapter {
	
    private final LayerUpdateDomainService service;

    private final LayerUpdateRestMapper mapper;

    @Operation(summary = "Layer Update", tags = "Layer")
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
            @RequestBody @Valid List<LayerUpdateRequest> layerUpdateRequests,
            HttpServletRequest request) {
    	
        log.info("Starting executing service PUT /layer - REQUEST: {}", layerUpdateRequests);

        service.perform(
        		mapper.toCommand(layerUpdateRequests), request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
