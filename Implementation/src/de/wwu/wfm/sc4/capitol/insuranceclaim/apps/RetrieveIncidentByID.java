package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.data.service.IncidentService;

public class RetrieveIncidentByID {
	private int incidentID;
	
	public void setIncidentID(int id) {
		incidentID = id;
	}
	
	public Incident complete() {
		return IncidentService.getSingleton().getByID(incidentID);
	}
}
