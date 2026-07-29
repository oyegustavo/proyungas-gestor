package ar.org.proyungas.infrastructure.output.persistence.vectoriallayer.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "vectorial-layer.status")
public class VectorialLayerStatusConfigurationProperties {
    private String withoutPresenting;
    private String ommited;
    private String inRevision;
    private String approved;
    private String observed;
}
