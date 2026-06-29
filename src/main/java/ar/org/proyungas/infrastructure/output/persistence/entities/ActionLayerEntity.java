package ar.org.proyungas.infrastructure.output.persistence.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
@Table(name = "actuaciones_capas")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionLayerEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actuacion_id", nullable = false)
    private ActionEntity action;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capa_template_id", nullable = false)
    private LayerTemplateEntity layerTemplate;

    @Column(name = "estado_actual", length = 20, nullable = false)
    private String currentStatus;

    @Column(name = "tecnico_asignado_id")
    private UUID technicianAssignedId;

    @Column(name = "version_actual_id")
    private UUID currentVersionId;

    @Column(name = "rehabilitada_desde_omitida", nullable = false)
    private Boolean reinstatedFromOmitted;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
