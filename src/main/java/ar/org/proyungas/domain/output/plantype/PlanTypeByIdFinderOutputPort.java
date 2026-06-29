package ar.org.proyungas.domain.output.plantype;

import java.util.UUID;

import ar.org.proyungas.domain.models.PlanType;

public interface PlanTypeByIdFinderOutputPort {
	PlanType perform(UUID id);
}
