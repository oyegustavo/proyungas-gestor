package ar.org.proyungas.domain.output.plantype;

import java.util.List;

import ar.org.proyungas.domain.models.PlanType;

public interface PlanTypeByEnabledFinderOutputPort {
	List<PlanType> perform(Boolean enabled);
}
