package ar.org.proyungas.domain.output.action;

import ar.org.proyungas.domain.models.Action;

public interface ActionByActionNumberOutputPort {
	Action perform(String actionNumber);
}
