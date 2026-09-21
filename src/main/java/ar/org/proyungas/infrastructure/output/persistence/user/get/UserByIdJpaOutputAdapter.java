package ar.org.proyungas.infrastructure.output.persistence.user.get;


import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.User;
import ar.org.proyungas.domain.output.user.UserByIdFinderOutputPort;
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
public class UserByIdJpaOutputAdapter implements UserByIdFinderOutputPort{
	
    private final UserByIdFinderAdapterMapper mapper;
    private final UserRepository repository;

	@Override
	public User peform(Integer id) {
        log.info("Start perform UserByIdJpaOutputAdapter with: {}", id);
        
        try {
            UserEntity entity = repository.findById(id).orElseThrow(
                    () -> new UserNotFoundException(ErrorCode.ROLE_NOT_FOUND_ERROR));
            log.info("UserByIdJpaOutputAdapter performed successfully with: {}", id);
            return mapper.toDomain(entity);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing UserByIdJpaOutputAdapter with: {}", id, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
    }
}
