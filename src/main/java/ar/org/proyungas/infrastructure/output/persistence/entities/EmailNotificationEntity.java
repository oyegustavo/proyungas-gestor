package ar.org.proyungas.infrastructure.output.persistence.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notificaciones_email")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailNotificationEntity {
	    @Id
	    @GeneratedValue
	    @Column(name = "id", nullable = false, updatable = false)
	    private UUID id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "actuacion_id", nullable = false)
	    private ActionEntity actuacion;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "capa_id")
	    private LayerTemplateEntity layer;

	    @Column(name = "destinatario_id", nullable = false)
	    private UUID recipientId;

	    @Column(name = "tipo_evento", length = 60, nullable = false)
	    private String eventType;

	    @Column(name = "estado_envio", length = 20, nullable = false)
	    private String sendingState;

	    @Column(name = "intentos", nullable = false)
	    private Integer attempts;

	    @Column(name = "celery_task_id", length = 100)
	    private String celeryTaskId;

	    @CreatedDate
	    @Column(name = "created_at", nullable = false)
	    private LocalDateTime createdAt;

	    @Column(name = "enviado_at")
	    private LocalDateTime sentAt;
}
