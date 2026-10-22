package ar.org.proyungas.application.layer.update;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

public interface LayerUpdateDomainService {
	void perform(List<LayerUpdaterDomainServiceCommand>commands, HttpServletRequest request);
}
