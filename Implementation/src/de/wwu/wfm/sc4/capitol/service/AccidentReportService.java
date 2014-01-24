package de.wwu.wfm.sc4.capitol.service;

import java.util.Date;

import ClaimData.ClaimReport;
import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.AccidentReport;
import de.wwu.wfm.sc4.capitol.data.Address;
import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Customer;
import de.wwu.wfm.sc4.capitol.data.Incident;

public class AccidentReportService extends AbstractServiceClass<AccidentReport> {
	protected AccidentReportService() {
		super();
	}

	public AccidentReport findById(int id) {
		return findById(AccidentReport.class, id);
	}

	public AccidentReport createFromDTO(DataTransferObject dto,
			Incident incident) {
		ClaimReport c = dto.getClaimData().getClaimReport();
		ServiceInitializer p = ServiceInitializer.getProvider();
		
		
		
		Address address = p.getAddressService().createFromClaimReport(c);
		
		Date date = c.getDate();
		Customer customer = p.getCustomerService().findByUsername(
		c.getCustomer().getUsername());
		Car car = p.getCarService().findByLicencePlate(c.getCar().getLicensePlate());
		String cause = c.getCause();
		String description = c.getDescription();
		
		
		AccidentReport accidentReport = 
			new AccidentReport(	address, 
								date, 
								customer, 
								car,
								cause, 
								description, 
								c.isMaintenace(), 
								c.isNeedsTow(), incident);
		// persist newly created AccidentReport
		p.getAccidentReportService().persist(accidentReport);
		return accidentReport;
	}
}
