package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.AccidentReport;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.IncidentService;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class UpdateAccidentReport {
	IncidentService service = ServiceInitializer.getProvider().getIncidentService();
	private Incident incident;
	private AccidentReport accidentReport;
	private DataTransferObject dto;
	
	public Incident complete() {
	
		/*if (incident.getAccidentReport() != null) {
			throw new IllegalStateException("Trying to add an accident report where there is one already!");
		}
		// TODO get AccidentReport from DTO
		incident.setAccidentReport(accidentReport);
		service.persist(incident);
		
		return incident;*/
		
		
		System.out.println("UpdateAccidentReport#complete()");
		return null;
	}
	
	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public void setDTO(DataTransferObject dto) {
		this.dto = dto;
	}
}
