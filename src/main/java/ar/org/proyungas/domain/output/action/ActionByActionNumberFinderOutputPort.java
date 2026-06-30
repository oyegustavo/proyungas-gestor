package ar.org.proyungas.domain.output.action;

import ar.org.proyungas.domain.models.Action;

public interface ActionByActionNumberFinderOutputPort {
	Action perform(String actionNumber);
}
