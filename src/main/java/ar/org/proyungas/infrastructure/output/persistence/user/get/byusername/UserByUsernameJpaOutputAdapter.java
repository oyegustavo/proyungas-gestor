package ar.org.proyungas.infrastructure.output.persistence.user.get.byusername;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.domain.output.user.UserByUsernameOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.UserEntity;
import ar.org.proyungas.infrastructure.output.persistence.user.repository.UserRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.UserNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class UserByUsernameJpaOutputAdapter implements UserByUsernameOutputPort{

    private final UserByUsernameFinderAdapterMapper mapper;
    private final UserRepository repository;
	
	@Override
	public User peform(String username) {
        log.info("Start perform UserByUsernameJpaOutputAdapter with: {}", username);
        
        try {
            UserEntity entity = repository.findByUsernameLikeIgnoreCase(username).orElseThrow(
                    () -> new UserNotFoundException(ErrorCode.USER_NOT_FOUND));
            log.info("UserByUsernameJpaOutputAdapter performed successfully with: {}", username);
            return mapper.toDomain(entity);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing UserByUsernameJpaOutputAdapter with: {}", username, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}
}
