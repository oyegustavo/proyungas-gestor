package ar.org.proyungas.application.plantype.get.byid;

import java.util.UUID;

public interface PlanTypeByIdFinder {
	PlanTypeByIdFinderResult perform(UUID id);
}
