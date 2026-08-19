package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import ar.org.proyungas.infrastructure.output.persistence.entities.ActionEntity;
import ar.org.proyungas.infrastructure.output.persistence.entities.LayerTemplateEntity;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EmailNotification {
    private UUID id;
    private ActionEntity action;
    private LayerTemplateEntity layerTemplate;
    private UUID recipientId;
    private String eventType;
    private String statusSent;
    private Integer attempts;
    private String celeryTaskId;
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
}
