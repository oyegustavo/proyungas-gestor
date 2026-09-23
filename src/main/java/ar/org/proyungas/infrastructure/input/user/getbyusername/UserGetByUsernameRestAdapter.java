package ar.org.proyungas.infrastructure.input.user.getbyusername;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.proyungas.application.user.get.byusername.UserByUsernameFinder;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users/{username}")
@Slf4j
@AllArgsConstructor
public class UserGetByUsernameRestAdapter {
	
    private final UserByUsernameFinder finder;
    private final UserByUsernameRestMapper mapper;

    @Operation(summary = "User by username", tags = "User")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Data sent ok"),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content) })
    @GetMapping
    public ResponseEntity<UserGetByUsernameResponse> perform(
    		@PathVariable String username) {
        log.info("Calling GET /user/username/{username} - username: {}", username);

        return ResponseEntity.ok(
                mapper.toResponse(finder.perform(username))
            );
    }
}
