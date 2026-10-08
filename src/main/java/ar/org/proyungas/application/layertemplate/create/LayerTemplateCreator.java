package ar.org.proyungas.application.layertemplate.create;

import jakarta.servlet.http.HttpServletRequest;

public interface LayerTemplateCreator {
	LayerTemplateCreateResult perform(LayerTemplateCreateCommand command, HttpServletRequest request);
}
