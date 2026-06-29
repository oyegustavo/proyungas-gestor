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
@Table(name = "historial_estados_capa")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayerStateHistory {
	    @Id
	    @GeneratedValue
	    @Column(name = "id", nullable = false, updatable = false)
	    private UUID id;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "capa_id", nullable = false)
	    private LayerTemplateEntity layerTemplate;

	    @Column(name = "estado_anterior", length = 20)
	    private String previousState;

	    @Column(name = "estado_nuevo", length = 20, nullable = false)
	    private String newState;

	    @Column(name = "accion", length = 50, nullable = false)
	    private String action;

	    @Column(name = "usuario_id", nullable = false)
	    private UUID userId;

	    @Column(name = "observacion")
	    private String observation;

	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "version_capa_id")
	    private LayerVersionEntity layerVersion;

	    @CreatedDate
	    @Column(name = "created_at", nullable = false)
	    private LocalDateTime createdAt;
}
