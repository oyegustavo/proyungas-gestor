package ar.org.proyungas.infrastructure.output.persistence.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "log_auditoria")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLogEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "usuario_id")
    private UUID userId;

    @Column(name = "tipo_accion", length = 80, nullable = false)
    private String actionType;

    @Column(name = "entidad_tipo", length = 50)
    private String entityType;

    @Column(name = "entidad_id")
    private UUID entityId;

    @Column(name = "estado_anterior", columnDefinition = "jsonb")
    private String previousState;

    @Column(name = "estado_nuevo", columnDefinition = "jsonb")
    private String newState;

    @Column(name = "ip_cliente", columnDefinition = "inet")
    private String clientIp;

    @Column(name = "user_agent")
    private String userAgent;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
