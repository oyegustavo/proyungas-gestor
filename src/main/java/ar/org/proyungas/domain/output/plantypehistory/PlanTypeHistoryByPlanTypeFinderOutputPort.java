package ar.org.proyungas.domain.output.plantypehistory;

import java.util.List;

import ar.org.proyungas.domain.models.PlanType;
import ar.org.proyungas.domain.models.PlanTypeHistory;

public interface PlanTypeHistoryByPlanTypeFinderOutputPort {
	List<PlanTypeHistory> perform(PlanType planType);
}
