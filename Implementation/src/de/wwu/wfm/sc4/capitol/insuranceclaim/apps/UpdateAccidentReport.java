package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import de.wwu.wfm.sc4.capitol.data.AccidentReport;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.data.service.IncidentService;

public class UpdateAccidentReport {
	IncidentService service = IncidentService.getSingleton();
	private Incident incident;
	private AccidentReport accidentReport;
	
	public Incident complete() {
	
		/*if (incident.getAccidentReport() != null) {
			throw new IllegalStateException("Trying to add an accident report where there is one already!");
		}
		
		incident.setAccidentReport(accidentReport);
		service.persist(incident);
		
		return incident;*/
		System.out.println("UpdateAccidentReport#complete()");
		return null;
	}
	
	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public void setAccidentReport(AccidentReport accidentReport) {
		this.accidentReport = accidentReport;
	}
}
