package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.IncidentService;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class StoreCoverageDecision {
	IncidentService service = ServiceInitializer.getProvider().getIncidentService();
	private Incident incident;
	private DataTransferObject originalDTO;
	
	public DataTransferObject complete() {
	
		/*if (incident.getAccidentReport() != null) {
			throw new IllegalStateException("Trying to add an accident report where there is one already!");
		}
		
		incident.setAccidentReport(accidentReport);
		service.persist(incident);
		
		return incident;*/
		System.out.println("StoreCoverageDecision#complete()");
		
		DataTransferObject outgoingDTO = new DataTransferObject();
		// TODO assemble DTO
		
		return outgoingDTO;
	}
	
	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public void setOriginalDTO(DataTransferObject originalDTO) {
		this.originalDTO = originalDTO;
	}

}
