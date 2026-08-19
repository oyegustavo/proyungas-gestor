package ar.org.proyungas.domain.output.action;

import ar.org.proyungas.domain.models.EmailNotification;

public interface EmailNotificationOutputPort {
	EmailNotification perform(EmailNotification emailNotification);
}