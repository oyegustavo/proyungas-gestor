package ar.org.proyungas.domain.output.action;

import java.util.UUID;

import ar.org.proyungas.domain.models.LayerVersion;

public interface LayerVersionByIdFinderOutputPort {
	LayerVersion perform(UUID id);
}
