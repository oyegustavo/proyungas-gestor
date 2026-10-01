package ar.org.proyungas.domain.output.plantype;

import ar.org.proyungas.domain.models.PlanType;

public interface PlanTypeDeleterOutputPort {
	void perform(PlanType planType);
}
