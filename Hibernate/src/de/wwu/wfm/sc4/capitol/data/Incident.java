package de.wwu.wfm.sc4.capitol.data;

public class Incident {
	private int incidentID;
	private Contract contract;
	private Car car;
	private AccidentReport accidentReport;
	
	
	public int getIncidentID() {
		return incidentID;
	}
	public void setIncidentID(int incidentID) {
		this.incidentID = incidentID;
	}
	public Contract getContract() {
		return contract;
	}
	public void setContract(Contract contract) {
		this.contract = contract;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public void setAccidentReport(AccidentReport accidentReport) {
		this.accidentReport = accidentReport;
	}
	public AccidentReport getAccidentReport() {
		return accidentReport;
	}
	
}
