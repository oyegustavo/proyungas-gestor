package ar.org.proyungas.domain.output.plantypehistory;

import ar.org.proyungas.domain.models.PlanTypeHistory;

public interface PlanTypeHistoryOutputPort {
	void perform(PlanTypeHistory domain);
}
