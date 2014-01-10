package de.wwu.wfm.sc4.capitol.service;

import de.wwu.wfm.sc4.capitol.data.DamageReport;

public class DamageReportService extends AbstractServiceClass<DamageReport> {
	protected DamageReportService(){
		super();
	}
	
	public DamageReport findById(int id) {
		return findById(DamageReport.class, id);
	}
}
