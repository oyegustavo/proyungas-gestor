package ar.org.proyungas.domain.models;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ActionLayer {
    UUID id;
    LayerTemplate layerTemplate;
    String currentStatus;
    UUID technicianAssignedId;
    UUID currentVersionId;
    Boolean reinstatedFromOmitted;
}
