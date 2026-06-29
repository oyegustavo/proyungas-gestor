package ar.org.proyungas.infrastructure.output.persistence.entities;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_plan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanTypeEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "codigo", length = 50, nullable = false)
    private String code;

    @Column(name = "nombre", length = 200, nullable = false)
    private String name;

    @Column(name = "grupo", length = 100, nullable = false)
    private String group;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "activo", nullable = false)
    private Boolean enabled;

    @Column(name = "fecha_desde")
    private LocalDate dateFrom;

    @Column(name = "fecha_hasta")
    private LocalDate dateTo;

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private OffsetDateTime updatedAt;
}
