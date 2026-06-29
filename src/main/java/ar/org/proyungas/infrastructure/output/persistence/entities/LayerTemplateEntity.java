package ar.org.proyungas.infrastructure.output.persistence.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "capas_template")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayerTemplateEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "codigo_capa", length = 100, nullable = false)
    private String layerCode;

    @Column(name = "label", length = 200, nullable = false)
    private String label;

    @Column(name = "requerida", nullable = false)
    private Boolean required;

    @Column(name = "orden", nullable = false)
    private Integer order;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "activa", nullable = false)
    private Boolean active;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_plan_id", nullable = false)
    private PlanTypeEntity planType;
}
