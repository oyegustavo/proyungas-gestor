package ar.org.proyungas.domain.output.action;

import java.util.UUID;

import ar.org.proyungas.domain.models.VectorialLayer;

public interface VectorialLayerByIdFinderOutputPort {
	VectorialLayer perform(UUID id);
}
