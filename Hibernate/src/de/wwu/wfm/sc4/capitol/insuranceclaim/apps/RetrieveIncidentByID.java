package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.insuranceclaim.logic.IncidentService;

public class RetrieveIncidentByID {
	IncidentService service = new IncidentService();
	private int incidentID;
	
	public void setIncidentID(int id) {
		incidentID = id;
	}
	
	public Incident complete() {
		return service.getByID(incidentID);
	}
}
