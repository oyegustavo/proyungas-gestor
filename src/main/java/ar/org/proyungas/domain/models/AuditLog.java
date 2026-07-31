package ar.org.proyungas.domain.models;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class AuditLog {
    UUID id;
    String username;
    String actionType;
    String entityType;
    UUID entityId;
    String previousState;
    String newState;
    String clientIp;
    String userAgent;
}
