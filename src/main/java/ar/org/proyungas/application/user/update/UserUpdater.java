package ar.org.proyungas.application.user.update;


public interface UserUpdater {
	void perform(UserUpdateCommand command);
}
