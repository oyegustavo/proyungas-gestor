package ar.org.proyungas.infrastructure.output.persistence.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
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
@Table(name = "tipo_plan")
@EntityListeners(AuditingEntityListener.class)
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
    private LocalDateTime dateFrom;

    @Column(name = "fecha_hasta")
    private LocalDateTime dateTo;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
