package ar.org.proyungas.application.action.create;

public interface ActionCreator {
	ActionCreateResult perform(ActionCreateCommand command);
}
