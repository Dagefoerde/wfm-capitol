package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;


import de.wwu.wfm.sc4.capitol.data.Incident;

public class CreateCoverageDecisionBean {
	private Incident incident;

	public CreateCoverageDecisionBean() {
	}

	public void complete() {
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public Incident getIncident() {
		return incident;
	}

}
