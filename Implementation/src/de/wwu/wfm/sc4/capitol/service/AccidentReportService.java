package de.wwu.wfm.sc4.capitol.service;

import de.wwu.wfm.sc4.capitol.data.AccidentReport;

public class AccidentReportService extends AbstractServiceClass<AccidentReport> {
	protected AccidentReportService(){
		super();
	}
	
	public AccidentReport findById(int id) {
		return findById(AccidentReport.class, id);
	}
}
