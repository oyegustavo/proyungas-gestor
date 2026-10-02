package ar.org.proyungas.application.plantype.get.bycriteria;

import java.time.LocalDateTime;
import java.util.UUID;

import ar.org.proyungas.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VectorialLayerByCriteriaFinderResult {
	UUID id;
	String currentStatus;
	User technicianAssigned;
	String observation;
	LayerVersionByCriteriaFinderResult currentVersion;
	Boolean reinstatedFromOmitted;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
