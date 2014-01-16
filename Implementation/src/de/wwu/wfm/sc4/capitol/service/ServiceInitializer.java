package de.wwu.wfm.sc4.capitol.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ServiceInitializer {
	private static ServiceInitializer provider;

	public static ServiceInitializer getProvider() {
		if (provider == null)
			provider = new ServiceInitializer();
		return provider;
	}

	public static ServiceInitializer p() { // synonym method for shorter access
		return getProvider();
	}

	private AccidentReportService accidentReportService;
	private CarService carService;
	private CaseService caseService;
	private ContractService contractService;
	private CustomerService customerService;
	private DamageReportService damageReportService;
	private IncidentService incidentService;
	private InvoiceService invoiceService;
	private RequirementsService requirementsService;
	private AddressService addressService;
	private ServiceStationService serviceStationService;
	private DamageReportEntryService damageReportEntryService;

	private SessionFactory sessionFactory;
	private Session session;

	private ServiceInitializer() {
		accidentReportService = new AccidentReportService();
		carService = new CarService();
		caseService = new CaseService();
		contractService = new ContractService();
		customerService = new CustomerService();
		damageReportService = new DamageReportService();
		incidentService = new IncidentService();
		invoiceService = new InvoiceService();
		requirementsService = new RequirementsService();
		addressService = new AddressService();
		serviceStationService = new ServiceStationService();
		damageReportEntryService = new DamageReportEntryService();

		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	public AccidentReportService getAccidentReportService() {
		return accidentReportService;
	}

	public CarService getCarService() {
		return carService;
	}

	public CaseService getCaseService() {
		return caseService;
	}

	public ContractService getContractService() {
		return contractService;
	}

	public CustomerService getCustomerService() {
		return customerService;
	}

	public DamageReportService getDamageReportService() {
		return damageReportService;
	}

	public IncidentService getIncidentService() {
		return incidentService;
	}

	public InvoiceService getInvoiceService() {
		return invoiceService;
	}

	public RequirementsService getRequirementsService() {
		return requirementsService;
	}

	public Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	public void closeSession() {
		if (session != null)
			session.close();
		session = null;
	}

	public AddressService getAddressService() {
		return addressService;
	}

	public ServiceStationService getServiceStationService() {
		return serviceStationService;
	}

	public DamageReportEntryService getDamageReportEntryService() {
		return damageReportEntryService;
	}
}
