package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import java.util.ArrayList;
import java.util.List;

import ClaimData.Entry;
import ContractData.Car;
import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.DamageReport;
import de.wwu.wfm.sc4.capitol.data.DamageReportEntry;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class CopyClaimDataIntoIncident {

	private DataTransferObject dto;
	private Incident incident;

	public void setDTO(DataTransferObject dto) {
		this.dto = dto;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public void complete() {
		// add car
		Car car = dto.getClaimData().getClaimReport().getCar();
		incident.setCar(ServiceInitializer.getProvider().getCarService()
				.findByLicencePlate(car.getLicensePlate()));

		// add dmg report
		List<Entry> dtoDamageList = dto.getClaimData().getDamageReport()
				.getDamageList();

		DamageReport damageReport = ServiceInitializer.getProvider()
				.getDamageReportService().convertFromDTODamageReport(
						dto.getClaimData().getDamageReport(), incident);

		incident.setDamageReport(damageReport);

		// persist
		ServiceInitializer.p().getIncidentService().persist(incident);
	}
}
