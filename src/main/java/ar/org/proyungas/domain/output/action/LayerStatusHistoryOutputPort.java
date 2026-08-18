package ar.org.proyungas.domain.output.action;

import ar.org.proyungas.domain.models.LayerStatusHistory;

public interface LayerStatusHistoryOutputPort {
	void perform(LayerStatusHistory layerStatusHistory);
}
