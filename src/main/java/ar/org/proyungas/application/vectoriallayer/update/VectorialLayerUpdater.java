package ar.org.proyungas.application.vectoriallayer.update;

import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;

public interface VectorialLayerUpdater {
	void perform(VectorialLayerUpdateCommand command, UUID id,HttpServletRequest request);
}
