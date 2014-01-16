package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.data.Invoice;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class UpdateInvoice {
	private Incident incident;
	private DataTransferObject dto;
	
	public Invoice complete(){
		ServiceInitializer s = ServiceInitializer.getProvider();
		Invoice invoice = s.getInvoiceService().createFromClaimData(dto.getClaimData(), incident);
		incident.addInvoice(invoice);
		s.getIncidentService().persist(incident);
		return invoice;
	}
	
	
	public void setIncident(Incident incident) {
		this.incident = incident;
	}
	
	public void setDto(DataTransferObject dto) {
		this.dto = dto;
	}
	
}
