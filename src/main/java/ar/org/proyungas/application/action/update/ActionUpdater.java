package ar.org.proyungas.application.action.update;

public interface ActionUpdater {
	void perform(ActionUpdateCommand command, String actionNumber);
}
