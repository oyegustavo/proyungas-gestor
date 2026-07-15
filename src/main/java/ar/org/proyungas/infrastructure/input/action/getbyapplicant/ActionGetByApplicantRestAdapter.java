package ar.org.proyungas.infrastructure.input.action.getbyapplicant;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.action.get.byapplicant.ActionByApplicantFinder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/action/applicant/{applicantId}")
@Slf4j
@AllArgsConstructor
public class ActionGetByApplicantRestAdapter {
    private final ActionByApplicantFinder finder;
    private final ActionByApplicantRestMapper mapper;

    @Operation(summary = "Action", tags = "Action")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Data sent ok"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content) })
    @GetMapping
    public ResponseEntity<List<ActionByApplicantResponse>> perform(
    		@PathVariable String applicantId,
    		@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("Calling GET /action/applicant/{applicantId} - applicantId: {}, page: {}, size: {}", applicantId, page, size);

        return ResponseEntity.ok(
                mapper.toResponse(finder.perform(applicantId, page, size))
            );
    }
}
