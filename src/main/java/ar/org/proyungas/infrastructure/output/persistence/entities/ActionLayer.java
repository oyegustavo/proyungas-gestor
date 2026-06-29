package ar.org.proyungas.infrastructure.output.persistence.entities;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ActionLayer {
    UUID id;
    LayerTemplateEntity layerTemplate;
    String currentStatus;
    UUID technicianAssignedId;
    UUID currentVersionId;
    Boolean reinstatedFromOmitted;
}
