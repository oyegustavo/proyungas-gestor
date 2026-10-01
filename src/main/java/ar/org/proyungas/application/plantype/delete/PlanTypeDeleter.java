package ar.org.proyungas.application.plantype.delete;

import java.util.UUID;

import jakarta.servlet.http.HttpServletRequest;

public interface PlanTypeDeleter {
	void perform(UUID planTypeId, HttpServletRequest request, String deleteReason);
}
