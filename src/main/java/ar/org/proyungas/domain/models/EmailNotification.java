package ar.org.proyungas.domain.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class EmailNotification {
    private UUID id;
    private Action action;
    private LayerTemplate layerTemplate;
    private String recipient;
    private String eventType;
    private String statusSent;
    private Integer attempts;
    private String celeryTaskId;
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;
}
