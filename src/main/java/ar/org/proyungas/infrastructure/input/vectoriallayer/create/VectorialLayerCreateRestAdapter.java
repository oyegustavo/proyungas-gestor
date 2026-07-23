package ar.org.proyungas.infrastructure.input.vectoriallayer.create;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.vectoriallayer.create.VectorialLayerCreator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/vectorial-layer")
@Slf4j
@AllArgsConstructor
public class VectorialLayerCreateRestAdapter {
	
    private final VectorialLayerCreator creator;

    private final VectorialLayerCreateRestMapper mapper;

    @Operation(summary = "Vectorial Layer Create", tags = "Vectorial Layers")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content) })

    @PostMapping
    public ResponseEntity<VectorialLayerCreateResponse> perform(@RequestBody @Valid VectorialLayerCreateRequest vectorialLayerCreateRequest
    		, HttpServletRequest request) {
    	creator.perform(mapper.toCommand(vectorialLayerCreateRequest), request);
        log.info("Start executing service POST /vectorial-layer - REQUEST: {}", request);
        return new ResponseEntity<>(mapper.toResponse(creator.perform(mapper.toCommand(vectorialLayerCreateRequest), request)),
                HttpStatus.CREATED);
    }
}
