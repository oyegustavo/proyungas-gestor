package ar.org.proyungas.application.action.update;

import jakarta.servlet.http.HttpServletRequest;

public interface ActionUpdater {
	void perform(ActionUpdateCommand command, String actionNumber, HttpServletRequest requests);
}
