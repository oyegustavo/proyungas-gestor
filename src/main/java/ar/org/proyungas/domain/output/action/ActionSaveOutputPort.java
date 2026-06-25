package ar.org.proyungas.domain.output.action;

import ar.org.proyungas.domain.models.Action;

public interface ActionSaveOutputPort {
    Action perform(Action action);
}
