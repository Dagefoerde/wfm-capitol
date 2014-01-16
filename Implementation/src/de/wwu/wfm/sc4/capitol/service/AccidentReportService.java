package de.wwu.wfm.sc4.capitol.service;

import ClaimData.ClaimReport;
import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.AccidentReport;
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
		AccidentReport accidentReport = 
			new AccidentReport(	p.getAddressService().createFromClaimReport(c), 
								c.getDate(), 
								p.getCustomerService().findByUsername(
								c.getCustomer().getUsername()), 
								p.getCarService().findByLicencePlate(c.getCar().getLicensePlate()),
								c.getCause(), 
								c.getDescription(), 
								c.isMaintenace(), 
								c.isNeedsTow(), incident);
		// persist newly created AccidentReport
		p.getAccidentReportService().persist(accidentReport);
		return accidentReport;
	}
}
