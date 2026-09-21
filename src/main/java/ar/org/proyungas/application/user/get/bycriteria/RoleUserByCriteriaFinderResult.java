package ar.org.proyungas.application.user.get.bycriteria;


import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class RoleUserByCriteriaFinderResult {
	Integer id;
	String role;
}
