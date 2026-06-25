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
@Table(name = "historial_tipos_plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanTypeHistory {
    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_plan_id", nullable = false)
    private PlanTypeEntity planType;

    @Column(name = "usuario_id", nullable = false)
    private UUID userId;

    @Column(name = "accion", length = 50, nullable = false)
    private String action;

    @Column(name = "comentario", nullable = false)
    private String comments;

    @Column(name = "datos_previos", columnDefinition = "jsonb")
    private String previousData;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
}
