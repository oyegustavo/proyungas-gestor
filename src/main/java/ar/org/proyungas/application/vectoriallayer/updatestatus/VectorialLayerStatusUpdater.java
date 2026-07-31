package ar.org.proyungas.application.vectoriallayer.updatestatus;

import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;

public interface VectorialLayerStatusUpdater {
	void perform(VectorialLayerStatusUpdateCommand command, UUID id,HttpServletRequest request);
}
