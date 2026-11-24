package ar.org.proyungas.application.action.get.byplantype;

import java.util.List;
import java.util.UUID;

public interface ActionByPlanTypeFinder {
	List<ActionByPlanTypeFinderResult> perform(UUID id);
}
