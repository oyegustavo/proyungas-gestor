package ar.org.proyungas.application.plantype.update;

import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;

public interface PlanTypeUpdater {
	void perform(PlanTypeUpdateCommand command, UUID planTypeId, HttpServletRequest request);
}
