package de.wwu.wfm.sc4.capitol.service;

import java.util.ArrayList;
import java.util.Collection;

import ClaimData.Entry;
import de.wwu.wfm.sc4.capitol.data.DamageReport;
import de.wwu.wfm.sc4.capitol.data.DamageReportEntry;
import de.wwu.wfm.sc4.capitol.data.Incident;

public class DamageReportService extends AbstractServiceClass<DamageReport> {
	protected DamageReportService() {
		super();
	}

	public DamageReport findById(int id) {
		return findById(DamageReport.class, id);
	}

	public ClaimData.DamageReport convertToDTODamageReport(
			DamageReport damageReport) {
		return new ClaimData.DamageReport(convertToDTODamageList(damageReport
				.getEntries()), damageReport.getContactPerson(),
				ServiceInitializer.p().getServiceStationService()
						.convertToDTOServiceStation(
								damageReport.getServiceStation()));
	}

	private ArrayList<Entry> convertToDTODamageList(
			Collection<DamageReportEntry> entries) {
		ArrayList<Entry> list = new ArrayList<Entry>();
		for (DamageReportEntry dre : entries) {
			list.add(ServiceInitializer.p().getDamageReportEntryService()
					.convertToDTOEntry(dre));
		}
		return null;
	}

	public DamageReport convertFromDTODamageReport(
			ClaimData.DamageReport damageReport, Incident incident) {
		DamageReport dr = new DamageReport(damageReport.getContactPerson(),
				ServiceInitializer.p().getServiceStationService()
						.convertFromDTOServiceStation(
								damageReport.getServiceStation()), incident,
				null);
		dr
				.setEntries(convertFromDTODamageList(damageReport
						.getDamageList(), dr));
		return dr;
	}

	private ArrayList<DamageReportEntry> convertFromDTODamageList(
			Collection<Entry> entries, DamageReport damageReport) {
		ArrayList<DamageReportEntry> damages = new ArrayList<DamageReportEntry>();
		for (Entry entry : entries) {
			damages.add(ServiceInitializer.p().getDamageReportEntryService()
					.convertFromDTOEntry(entry, damageReport));
		}
		return damages;
	}

}
