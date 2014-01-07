package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;
import java.util.List;

public class Incident implements Serializable{
	
	private Integer incidentID;

	private Contract contract;
	private Integer contractID;

	private Car car;
	private Integer carID;

	private AccidentReport accidentReport;
	private Integer accidentReportID; 

	private DamageReport damageReport;
	private Integer damageReportID;

	private List<Invoice> invoices;

	public Contract getContract() {
		if (contract != null) 
			return contract;
		
		if (contractID != null) {
			// TODO
			// contract = ContractService.getSingleton().getById(contractID);
			// return contract;
		}
		
		return null;
	}
	
	public void setContract(Contract c) {
		// TODO
		//contractID = c.getID();
		contract = c;
	}
	
	public List<Invoice> getInvoices() {
		if (invoices != null)
			return invoices;
		
		if (incidentID == null) {
			// incident is not saved yet, therefore there are no related invoices!
			return null;	
		}
		
		// TODO
		//invoices = InvoiceService.getSingleton().getAllByIncidentId(incidentID);
		return invoices;
	}
	
}
