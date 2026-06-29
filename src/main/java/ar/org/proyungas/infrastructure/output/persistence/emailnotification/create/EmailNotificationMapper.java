package ar.org.proyungas.infrastructure.output.persistence.emailnotification.create;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import ar.org.proyungas.domain.models.EmailNotification;
import ar.org.proyungas.infrastructure.output.persistence.entities.EmailNotificationEntity;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmailNotificationMapper {
    EmailNotification toDomain(EmailNotificationEntity entity);
    EmailNotificationEntity toEntity(EmailNotification domain);
}
