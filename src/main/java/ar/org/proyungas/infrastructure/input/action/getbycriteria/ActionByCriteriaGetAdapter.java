package ar.org.proyungas.infrastructure.input.action.getbycriteria;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.action.get.bycriteria.ActionByCriteriaFinder;
import ar.org.proyungas.application.action.get.bycriteria.ActionByCriteriaFinderQuery;
import ar.org.proyungas.shared.infrastructure.utils.PageResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.Explode;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/action/filter/")
@AllArgsConstructor
public class ActionByCriteriaGetAdapter {
	   private final ActionByCriteriaFinder actionByCriteriaFinder;
	    private final ActionByCriteriaGetMapper mapper;
	    
	    @Operation(summary = "List Action", tags = "Action")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "Data sent ok"),
	            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
	            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
	            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
	            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content),
	            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content)
	    })
	    @GetMapping
	    public ResponseEntity<PageResult<ActionByCriteriaGetResponse>> perform(
	            @RequestParam(name = "size", required = false, defaultValue = "10") int size,
	            @RequestParam(name = "page", required = false, defaultValue = "1") int page,
	            @Parameter(
	                    explode = Explode.TRUE,
	                    in = ParameterIn.QUERY,
	                    name = "queryParams",
	                    schema = @Schema(type = "object"),
	                    examples = {
	                            @ExampleObject(name = "actionNumber contains operation", value = "{\"actionNumber\":\"contains:Alf\"}"),
	                            @ExampleObject(name = "propertyOwner equals operation", value = "{\"propertyOwner\":\"equals:12-34567876-9\"}")
	                    },
	                    description = "Enabled filters: actionNumber, propertyOwner")
	            @RequestParam Map<String, String> filters) {


	        log.info("Calling GET /action/filter/ with page {}, size {} and filters {}", page, size, filters);

	        ActionByCriteriaFinderQuery query = buildQuery(page, size, filters);

	        return ResponseEntity.ok(mapper.toResponse(actionByCriteriaFinder.perform(query)));
	    }

	    private ActionByCriteriaFinderQuery buildQuery(Integer page, Integer size, Map<String, String> filters) {
	        return ActionByCriteriaFinderQuery.builder()
	                .size(size)
	                .page(page)
	                .filters(filters)
	                .build();
	    }
}
