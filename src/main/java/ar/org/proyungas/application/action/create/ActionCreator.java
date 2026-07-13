package ar.org.proyungas.application.action.create;

import jakarta.servlet.http.HttpServletRequest;

public interface ActionCreator {
	ActionCreateResult perform(ActionCreateCommand command,  HttpServletRequest request);
}
