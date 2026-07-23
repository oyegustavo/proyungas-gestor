package ar.org.proyungas.domain.output.action;

import java.util.UUID;

import ar.org.proyungas.domain.models.LayerTemplate;

public interface LayerTemplateByIdFinderOutputPort {
	LayerTemplate perform(UUID id);
}
