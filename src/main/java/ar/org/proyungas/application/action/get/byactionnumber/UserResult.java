package ar.org.proyungas.application.action.get.byactionnumber;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserResult {
	Integer id;
	String username;
	String fullname;
	String email;
}
