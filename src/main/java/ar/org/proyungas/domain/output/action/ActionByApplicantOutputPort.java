package ar.org.proyungas.domain.output.action;

import java.util.List;

import ar.org.proyungas.domain.models.Action;

public interface ActionByApplicantOutputPort {
	List<Action> perform(String applicantId);
}
