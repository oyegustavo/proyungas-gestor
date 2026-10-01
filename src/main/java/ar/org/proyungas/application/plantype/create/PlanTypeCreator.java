package ar.org.proyungas.application.plantype.create;

import jakarta.servlet.http.HttpServletRequest;

public interface PlanTypeCreator {
	PlanTypeCreateResult perform(PlanTypeCreateCommand command, HttpServletRequest request);
}
