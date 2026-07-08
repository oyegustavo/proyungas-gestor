package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EmailNotification {
	UUID id;
	LayerTemplate layer;
	UUID recipientId;
	String eventType;
	String sendingState;
	Integer attempts;
	String celeryTaskId;
	LocalDateTime sentAt;
}
