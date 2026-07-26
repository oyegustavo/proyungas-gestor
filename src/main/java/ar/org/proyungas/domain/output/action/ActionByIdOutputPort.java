package ar.org.proyungas.domain.output.action;

import java.util.UUID;

import ar.org.proyungas.domain.models.Action;

public interface ActionByIdOutputPort {
    Action perform(UUID id);
}
