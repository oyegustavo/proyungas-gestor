package ar.org.proyungas.application.user.update;


import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.domain.output.user.RoleByIdFinderOutputPort;
import ar.org.proyungas.domain.output.user.UserByIdFinderOutputPort;
import ar.org.proyungas.domain.output.user.UserSaveOutputPort;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.InvalidUserException;
import ar.org.proyungas.shared.infrastructure.input.UserBadRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class UserUpdateUseCase implements UserUpdater{
	
	private final UserUpdateMapper mapper;
	private final UserSaveOutputPort outputPort;
	private final UserByIdFinderOutputPort userByIdFinderOutputPort;
	private final RoleByIdFinderOutputPort roleByIdFinderOutputPort;

	@Override
	public void perform(UserUpdateCommand command) {
		
        log.info("Updating User with ID: {}", command.getId());
        
        validateRoles(command.getRoles());
        
        User existing = userByIdFinderOutputPort.peform(command.getId());

        if (!existing.getEnabled()) {
            log.info("The User {} is not active", command.getId());
            throw new InvalidUserException(ErrorCode.INVALID_USER_ERROR);
        }
        try {
            outputPort.perform(mapper.toDomain(command, existing));
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
}
