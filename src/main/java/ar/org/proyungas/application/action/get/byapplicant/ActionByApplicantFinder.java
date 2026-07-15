package ar.org.proyungas.application.action.get.byapplicant;

import java.util.List;

public interface ActionByApplicantFinder {
	List<ActionByApplicantResult> perform(String applicantId);

}
