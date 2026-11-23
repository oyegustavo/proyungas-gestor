package ar.org.proyungas.application.plantypehistory.get.byplantype;

import java.util.List;

import ar.org.proyungas.application.layertemplate.create.PlanTypeCommand;

public interface PlanTypeHistoryByPlanTypeFinder {
	List<PlanTypeHistoryByPlanTypeResult> perform(PlanTypeCommand command);
}
