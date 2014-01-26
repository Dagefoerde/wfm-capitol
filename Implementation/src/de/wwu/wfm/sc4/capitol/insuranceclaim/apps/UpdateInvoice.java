package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ContractData.ContractData;
import ContractData.InsuranceContract;
import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.constants.CapitolConstants;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.data.Invoice;
import de.wwu.wfm.sc4.capitol.service.FileService;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class UpdateInvoice {
	private Incident incident;
	private DataTransferObject dto;
	
	public Invoice complete(){
		ServiceInitializer s = ServiceInitializer.getProvider();
		Invoice invoice = s.getInvoiceService().createFromClaimData(dto.getClaimData(), incident);
		incident.addInvoice(invoice);
		s.getIncidentService().persist(incident);
		
      
        //save pdf to file
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMDD");
		String fileName = df.format(invoice.getDate())+"-"+ invoice.getInvoiceNumber() +".pdf";
        FileService.createFolderIfItDoesNotExist(CapitolConstants.INVOICE_PATH);
        String path=CapitolConstants.INVOICE_PATH+"/"+fileName;
        invoice.setPath(fileName);
        try {
            FileOutputStream output=new FileOutputStream(path);
			output.write(invoice.getInvoiceDocument());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return invoice;
	}
	
	
	public void setIncident(Incident incident) {
		this.incident = incident;
	}
	
	public void setDto(DataTransferObject dto) {
		this.dto = dto;
	}
	
}
