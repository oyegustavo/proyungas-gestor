package ar.org.proyungas.application.plantype.get.byenabled;

import java.util.List;

public interface PlanTypeByEnabledFinder {
	List<PlanTypeByEnabledResult> perform(Boolean enabled);
}
