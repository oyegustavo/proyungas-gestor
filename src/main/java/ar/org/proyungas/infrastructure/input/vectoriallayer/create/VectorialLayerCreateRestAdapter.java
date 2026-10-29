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
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
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

    @Operation(
            summary = "Vectorial Layer Create",
            tags = "Vectorial Layer",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                content = @Content(
                    schema = @Schema(implementation = VectorialLayerCreateRequest.class),
                    examples = {
                        @ExampleObject(
                            value = "{\n" +
                                    "  \"template_layer\": { \"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\" },\n" +
                                    "  \"action\": { \"id\": \"11111111-2222-3333-4444-555555555555\" },\n" +
                                    "  \"layer_version\": {\n" +
                                    "    \"layer_template\": { \"id\": \"3fa85f64-5717-4562-b3fc-2c963f66afa6\" },\n" +
                                    "    \"version_number\": 1,\n" +
                                    "    \"formatt\": \"shp\",\n" +
                                    "    \"original_number\": \"layer_v1.shp\",\n" +
                                    "    \"minio_path\": \"layers/2026/10/layer_v1.shp\",\n" +
                                    "    \"minio_bucket\": \"vectorial-layers\",\n" +
                                    "    \"bytes_size\": 123456,\n" +
                                    "    \"hash_sha256\": \"abcdef1234567890abcdef1234567890abcdef1234567890abcdef1234567890\",\n" +
                                    "    \"coords_system\": \"EPSG:4326\",\n" +
                                    "    \"uploaded_by_id\": 1\n" +
                                    "  },\n" +
                                    "  \"technician_assigned_id\": 1,\n" +
                                    "  \"reinstated_from_omitted\": true\n" +
                                    "}"
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
    public ResponseEntity<VectorialLayerCreateResponse> perform(@RequestBody @Valid VectorialLayerCreateRequest vectorialLayerCreateRequest
    		, HttpServletRequest request) {
        log.info("Start executing service POST /vectorial-layer - REQUEST: {}", vectorialLayerCreateRequest);
        return new ResponseEntity<>(mapper.toResponse(creator.perform(mapper.toCommand(vectorialLayerCreateRequest), request)),
                HttpStatus.CREATED);
    }
}
