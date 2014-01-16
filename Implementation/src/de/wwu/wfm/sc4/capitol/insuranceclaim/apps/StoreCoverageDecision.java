package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.DamageReportService;
import de.wwu.wfm.sc4.capitol.service.IncidentService;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class StoreCoverageDecision {
	IncidentService service = ServiceInitializer.getProvider()
			.getIncidentService();
	private Incident incident;
	private DataTransferObject dto;

	public DataTransferObject complete() {

		if (incident.getAccidentReport() != null) {
			throw new IllegalStateException(
					"Trying to add an accident report where there is one already!");
		}
		service.persist(incident);

		DamageReportService drs = ServiceInitializer.p()
				.getDamageReportService();
		dto.getClaimData().setDamageReport(
				drs.convertToDTODamageReport(incident.getDamageReport()));
		return dto;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public void setDTO(DataTransferObject dto) {
		this.dto = dto;
	}

}
