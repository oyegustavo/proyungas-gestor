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
@Table(name = "versiones_capa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LayerVersionEntity {
    @Id
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

    @Column(name = "created_at", nullable = false)
    private OffsetDateTime createdAt;
}
