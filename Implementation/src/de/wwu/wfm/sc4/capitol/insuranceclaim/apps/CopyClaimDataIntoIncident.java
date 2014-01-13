package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import java.util.ArrayList;
import java.util.List;

import ClaimData.Entry;
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
		ContractData.Car car = dto.getClaimData().getClaimReport().getCar();
		// TODO convert into internal db car!
		incident.setCar(null);
		
		
		// add dmg report
		List<Entry> dtoDamageList = dto.getClaimData().getDamageReport().getDamageList();
		ArrayList<DamageReportEntry> damages = new ArrayList<DamageReportEntry>(dtoDamageList.size());

		DamageReport damageReport = new DamageReport();
		damageReport.setEntries(damages);
		for (Entry e : dtoDamageList) {
			DamageReportEntry damage = new DamageReportEntry();
			damage.setPosition(e.getiD());
			damage.setDescription(e.getDescription());
			damage.setCostEstimation(e.getCostEstimation());
			damage.setCoverageDecision(e.getCoverageDecision() == null? false : e.getCoverageDecision());
			
			damages.add(damage);
			damage.setDamageReport(damageReport);
		}
		
		incident.setDamageReport(damageReport);
		
		// persist
		ServiceInitializer.p().getIncidentService().persist(incident);
		ServiceInitializer.p().getDamageReportService().persist(damageReport);
	}
}
