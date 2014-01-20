package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class RetrieveIncidentByID {
	private DataTransferObject dto;

	public void setDTO(DataTransferObject dto) {
		this.dto = dto;
	}

	public Incident complete() {
		Incident incident = ServiceInitializer.p().getIncidentService()
				.findBySharedId(dto.getClaimData().getId());
		if (incident != null) {
			ServiceInitializer.p().getIncidentService().initializeIncident(incident);
		}
		return incident;
	}
}
