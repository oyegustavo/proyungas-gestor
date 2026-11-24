package ar.org.proyungas.domain.output.action;

import java.util.List;

import ar.org.proyungas.domain.models.Action;
import ar.org.proyungas.domain.models.PlanType;

public interface ActionByPlanTypeOutputPort {
	List<Action> perform(PlanType planType);
}
