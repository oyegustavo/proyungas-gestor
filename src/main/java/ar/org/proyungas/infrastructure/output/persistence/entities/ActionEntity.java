package ar.org.proyungas.infrastructure.output.persistence.entities;

import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "actuaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActionEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "numero_actuacion", length = 30, nullable = false)
    private String actionNumber;

    @ManyToOne
    @JoinColumn(name = "tipo_plan_id", nullable = false)
    private PlanTypeEntity planType;

    @Column(name = "propietario_predio", length = 300, nullable = false)
    private String propertyOwner;

    @Column(name = "solicitante_id", nullable = false)
    private String applicantId;

    @Column(name = "cargado_por_id")
    private String uploadedById;

    @Column(name = "estado_derivado", length = 20, nullable = false)
    private String derivativeStatus;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;

    @Column(name = "deleted_at")
    private OffsetDateTime deletedAt;
}
