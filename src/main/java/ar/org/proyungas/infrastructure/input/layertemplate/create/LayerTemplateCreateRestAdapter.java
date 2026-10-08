package ar.org.proyungas.infrastructure.input.layertemplate.create;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.layertemplate.create.LayerTemplateCreator;
import ar.org.proyungas.infrastructure.input.vectoriallayer.create.LayerTemplateCreateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/layer-template")
@Slf4j
@AllArgsConstructor
public class LayerTemplateCreateRestAdapter {
	
    private final LayerTemplateCreator layerTemplateCreate;

    private final LayerTemplateCreateRestMapper mapper;

    @Operation(summary = "Layer Template Create", tags = "Layer Template")
    @ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content) })

    @PostMapping
    public ResponseEntity<LayerTemplateCreateResponse> perform(@RequestBody @Valid LayerTemplateCreateRequest layerTemplateCreateRequest
    		, HttpServletRequest request) {
        log.info("Start executing service POST /layer-template - REQUEST: {}", request);
        return new ResponseEntity<>(mapper.toResponse(layerTemplateCreate.perform(mapper.toCommand(layerTemplateCreateRequest), request)),
                HttpStatus.CREATED);
    }
}
