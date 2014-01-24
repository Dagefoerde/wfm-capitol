package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;


import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class CreateCoverageDecisionBean {
	private Incident incident;

	public CreateCoverageDecisionBean() {
	}

	public void complete() {
	}

	public void setIncident(Incident incident) {
		this.incident = ServiceInitializer.p().getIncidentService().findById(incident.getId());
		ServiceInitializer.p().getIncidentService().initializeIncident(this.incident);
	}

	public Incident getIncident() {
		return incident;
	}

}
