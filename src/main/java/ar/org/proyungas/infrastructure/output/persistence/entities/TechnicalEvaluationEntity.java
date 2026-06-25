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
@Table(name = "evaluaciones_tecnicas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TechnicalEvaluationEntity {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capa_id", nullable = false)
    private LayerTemplateEntity layer;

    @Column(name = "tecnico_id", nullable = false)
    private UUID technicianId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "version_capa_id", nullable = false)
    private LayerVersionEntity layerVersion;

    @Column(name = "resultado", length = 20, nullable = false)
    private String result;

    @Column(name = "observacion")
    private String observation;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
}
