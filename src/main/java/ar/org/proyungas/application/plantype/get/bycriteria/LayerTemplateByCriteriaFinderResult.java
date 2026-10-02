package ar.org.proyungas.application.plantype.get.bycriteria;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LayerTemplateByCriteriaFinderResult {
	UUID id;
	String layerCode;
	String label;
	Boolean required;
	Integer order;
	String description;
	Boolean active;
    List<VectorialLayerByCriteriaFinderResult> vectorialLayers;
}
