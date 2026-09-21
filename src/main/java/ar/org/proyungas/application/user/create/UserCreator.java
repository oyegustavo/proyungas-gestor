package ar.org.proyungas.application.user.create;


public interface UserCreator {
	UserCreateResult perform(UserCreateCommand command);
}
