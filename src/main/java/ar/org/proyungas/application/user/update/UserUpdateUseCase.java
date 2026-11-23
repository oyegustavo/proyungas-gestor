package ar.org.proyungas.application.user.update;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Role;
import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.domain.output.user.RoleByIdFinderOutputPort;
import ar.org.proyungas.domain.output.user.UserByIdFinderOutputPort;
import ar.org.proyungas.domain.output.user.UserSaveOutputPort;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.UserBadRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class UserUpdateUseCase implements UserUpdater{
	
	private final UserSaveOutputPort outputPort;
	private final UserByIdFinderOutputPort userByIdFinderOutputPort;
	private final RoleByIdFinderOutputPort roleByIdFinderOutputPort;

	@Override
	public void perform(UserUpdateCommand command) {
		
	    log.info("Updating User with ID: {}", command.getId());

	    validateRoles(command.getRoles());

	    User existing = userByIdFinderOutputPort.peform(command.getId());

	    // Merge changes
	    User updated = merge(existing, command);

	    try {
	        outputPort.perform(updated);
	    } catch (DataIntegrityViolationException e) {
	        log.error("DataIntegrityViolationException - {}", e.getLocalizedMessage());
	        throw new UserBadRequestException(ErrorCode.USER_BAD_REQUEST);
	    }
	}
	
	private void validateRoles(List<RoleUpdateCommand> roles) {
		for (RoleUpdateCommand role : roles) {
			roleByIdFinderOutputPort.perform(role.getId());
		}
	}
	
	
	private User merge(User existing, UserUpdateCommand command) {
	    User.UserBuilder builder = existing.toBuilder();

	    if (command.getUsername() != null && !command.getUsername().equals(existing.getUsername())) {
	        builder.username(command.getUsername());
	    }
	    if (command.getFullname() != null && !command.getFullname().equals(existing.getFullname())) {
	        builder.fullname(command.getFullname());
	    }
	    if (command.getEmail() != null && !command.getEmail().equals(existing.getEmail())) {
	        builder.email(command.getEmail());
	    }
	    if (command.getPassword() != null && !command.getPassword().equals(existing.getPassword())) {
	        builder.password(command.getPassword());
	    }
	    if (command.getEnabled() != null && !command.getEnabled().equals(existing.getEnabled())) {
	        builder.enabled(command.getEnabled());
	    }
	    if (command.getRoles() != null) {
	        List<Role> newRoles = command.getRoles().stream()
	            .map(r -> Role.builder().id(r.getId()).role(r.getRole()).build())
	            .collect(Collectors.toList());
	        if (!newRoles.equals(existing.getRoles())) {
	            builder.roles(newRoles);
	        }
	    }

	    return builder.build();
	}

}
