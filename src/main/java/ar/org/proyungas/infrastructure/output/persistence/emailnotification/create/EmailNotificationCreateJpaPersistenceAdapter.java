package ar.org.proyungas.infrastructure.output.persistence.emailnotification.create;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import ar.org.proyungas.domain.models.EmailNotification;
import ar.org.proyungas.domain.output.action.EmailNotificationOutputPort;
import ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.repository.EmailNotificationRepository;
import ar.org.proyungas.shared.infrastructure.input.DatabaseConnectionException;
import ar.org.proyungas.shared.infrastructure.input.EmailNotificationBadRequestException;
import ar.org.proyungas.shared.infrastructure.input.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@AllArgsConstructor
public class EmailNotificationCreateJpaPersistenceAdapter implements EmailNotificationOutputPort{

    private final EmailNotificationMapper mapper;
    private final EmailNotificationRepository repository;
	
	@Override
	public EmailNotification perform(EmailNotification emailNotification) {
        log.info("Starting perform EmailNotificationCreateJpaPersistenceAdapter with data: {}", emailNotification);
        try {
        	return mapper.toDomain(repository.save(mapper.toEntity(emailNotification)));
        } catch (DataIntegrityViolationException e) {
            log.error("DataIntegrityViolationException while performing EmailNotificationCreateJpaPersistenceAdapter with data {}", emailNotification, e);
            throw new EmailNotificationBadRequestException(ErrorCode.EMAIL_NOTIFICATION_ERROR);
        } catch (DataAccessException e) {
            log.error("DataAccessException while performing EmailNotificationCreateJpaPersistenceAdapter with data {}", emailNotification, e);
            throw new DatabaseConnectionException(ErrorCode.DATABASE_ERROR);
        }
	}

}
