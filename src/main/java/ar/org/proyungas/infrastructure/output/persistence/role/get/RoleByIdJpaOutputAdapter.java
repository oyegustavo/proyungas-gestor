package ar.org.proyungas.infrastructure.output.persistence.role.get;



import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Role;
import ar.org.proyungas.domain.output.user.RoleByIdFinderOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.entities.RoleEntity;
import ar.org.proyungas.infrastructure.output.persistence.role.repository.RoleRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import ar.org.proyungas.shared.infrastructure.input.RoleNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class RoleByIdJpaOutputAdapter implements RoleByIdFinderOutputPort{
	
    private final RoleByIdFinderAdapterMapper mapper;
    private final RoleRepository repository;
    
    @Override
    public Role perform(Integer id) {
        log.info("Start perform AudienceTypeByIdJpaOutputAdapter with: {}", id);
        
        try {
            RoleEntity entity = repository.findById(id).orElseThrow(
                    () -> new RoleNotFoundException(ErrorCode.ROLE_NOT_FOUND_ERROR));
            log.info("AudienceTypeByIdJpaOutputAdapter performed successfully with: {}", id);
            return mapper.toDomain(entity);
        } catch (DataAccessException e) {
            log.error("Database connection error while performing AudienceTypeByIdJpaOutputAdapter with: {}", id, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
    }
}
