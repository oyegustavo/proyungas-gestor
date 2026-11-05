package ar.org.proyungas.application.action.get.byactionnumber;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import ar.org.proyungas.application.plantype.create.LayerTemplateResult;
import ar.org.proyungas.domain.models.User;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class VectorialLayerResult {
    UUID id;
    LayerTemplateResult templateLayer;
    String currentStatus;
    User technicianAssigned;
    String observation;
    LayerVersionResult currentVersion;
    Boolean reinstatedFromOmitted;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    List<LayerVersionResult> versions;
}
