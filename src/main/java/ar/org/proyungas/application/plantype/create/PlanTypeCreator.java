package ar.org.proyungas.application.plantype.create;

public interface PlanTypeCreator {
	PlanTypeCreateResult perform(PlanTypeCreateCommand command);
}
