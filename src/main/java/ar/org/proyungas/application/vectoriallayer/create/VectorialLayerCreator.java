package ar.org.proyungas.application.vectoriallayer.create;

import jakarta.servlet.http.HttpServletRequest;

public interface VectorialLayerCreator {
	VectorialLayerCreateResult perform(VectorialLayerCreateCommand command, HttpServletRequest request);
}
