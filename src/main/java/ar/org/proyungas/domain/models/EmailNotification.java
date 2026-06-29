package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import ar.org.proyungas.infrastructure.output.persistence.entities.LayerTemplateEntity;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EmailNotification {
	UUID id;
	LayerTemplateEntity layer;
	UUID recipientId;
	String eventType;
	String sendingState;
	Integer attempts;
	String celeryTaskId;
	LocalDateTime sentAt;
}
