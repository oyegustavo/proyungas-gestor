package ar.org.proyungas.infrastructure.output.persistence.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "capas_vectoriales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VectorialLayerEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actuacion_id", nullable = false)
    private ActionEntity action;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capa_template_id", nullable = false)
    private LayerTemplateEntity templateLayer;

    @Column(name = "estado_actual", length = 20, nullable = false)
    private String currentStatus;

    @Column(name = "tecnico_asignado_id")
    private UUID technicianAssignedId;

    @Column(name = "version_actual_id")
    private UUID currentVersionId;

    @Column(name = "rehabilitada_desde_omitida", nullable = false)
    private Boolean reinstatedFromOmitted;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;
}
