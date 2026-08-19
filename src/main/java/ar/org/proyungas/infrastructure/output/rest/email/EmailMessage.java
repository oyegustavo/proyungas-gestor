package ar.org.proyungas.infrastructure.output.rest.email;


import java.util.Map;

import ar.org.proyungas.shared.infrastructure.utils.EmailTemplateType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmailMessage {
    private String to;
    private EmailTemplateType templateType;   // e.g. CAPA_OBSERVADA, CAPA_APROBADA
    private Map<String, Object> model;        // dynamic variables for the template
    private int retries;
}
