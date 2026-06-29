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
@Table(name = "versiones_capa")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayerVersionEntity {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capa_id", nullable = false)
    private LayerTemplateEntity layerTemplate;

    @Column(name = "numero_version", nullable = false)
    private Integer versionNumber;

    @Column(name = "formato", length = 20, nullable = false)
    private String formatt;

    @Column(name = "nombre_original", length = 500, nullable = false)
    private String originalNumber;

    @Column(name = "ruta_minio", nullable = false)
    private String minioPath;

    @Column(name = "bucket_minio", length = 100, nullable = false)
    private String minioBucket;

    @Column(name = "tamanio_bytes", nullable = false)
    private Long bytesSize;

    @Column(name = "hash_sha256", length = 64, nullable = false)
    private String hashSha256;

    @Column(name = "sistema_coords", length = 50)
    private String coordsSystem;

    @Column(name = "subido_por_id", nullable = false)
    private UUID uploadedById;

    @CreatedDate
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
