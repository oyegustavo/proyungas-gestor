package ar.org.proyungas.infrastructure.output.rest.email;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "service-client.email")
public class EmailSenderAdapterConfigurationProperties {
    private String emailUri;
    private String baseUri;
}
