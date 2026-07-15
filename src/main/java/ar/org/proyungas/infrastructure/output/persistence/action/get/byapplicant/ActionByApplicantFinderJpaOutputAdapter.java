package ar.org.proyungas.infrastructure.output.persistence.action.get.byapplicant;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.output.action.ActionByApplicantOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.action.create.ActionPersistenceMapper;
import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.repository.ActionRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class ActionByApplicantFinderJpaOutputAdapter implements ActionByApplicantOutputPort{

	private final ActionRepository repository;
	private final ActionPersistenceMapper mapper;
	
	@Override
	public List <Action> perform(String applicantId, Integer page, Integer size) {
		log.info("Starting ActionByApplicantFinderJpaOutputAdapter applicantId: {}", applicantId);

		try {
		    Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").ascending());
		    Page<ActionEntity> actionEntities = repository.findByApplicantIdOrderByCreatedAtAsc(applicantId, pageable);
			return mapper.toDomain(actionEntities.getContent());
		} catch (DataAccessException e) {
			log.error(
					"Database connection error while performing ActionByApplicantFinderJpaOutputAdapter with applicantId: {}",
					applicantId, e);
			throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
		}
	}
}