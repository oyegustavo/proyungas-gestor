package ar.org.proyungas.infrastructure.output.rest.email;

public interface EmailSenderOutputPort {
	void perform(EmailMessage emailMessage);
}
