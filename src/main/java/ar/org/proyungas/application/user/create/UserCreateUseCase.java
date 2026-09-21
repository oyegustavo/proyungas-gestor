package ar.org.proyungas.application.user.create;


import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.output.user.RoleByIdFinderOutputPort;
import ar.org.proyungas.domain.output.user.UserSaveOutputPort;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.UserBadRequestException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class UserCreateUseCase implements UserCreator{
	
	private final UserCreateMapper mapper;
	private final UserSaveOutputPort outputPort;
	private final RoleByIdFinderOutputPort roleByIdFinderOutputPort;

	@Override
	public UserCreateResult perform(UserCreateCommand command) {
		log.info("Starting performing CrimeTypeCreateUseCase with data: {}", command);
		
		validateRoles(command.getRoles());
		
		try {
			return mapper.toResult(outputPort.perform(mapper.toDomain(command)));
		} catch (DataIntegrityViolationException e) {
			log.error("DataIntegrityViolationException - {}", e.getLocalizedMessage());
			throw new UserBadRequestException(ErrorCode.BAD_REQUEST_ERROR);
		}
	}
	
	private void validateRoles(List<RoleCreateCommand> roles) {
		for (RoleCreateCommand role : roles) {
			roleByIdFinderOutputPort.perform(role.getId());
		}
	}
}
