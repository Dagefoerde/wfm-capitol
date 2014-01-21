package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Customer;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class TransferDataFromCustomerRequirementsToCase {

	private DataTransferObject dto;
	private Case case0;

	public TransferDataFromCustomerRequirementsToCase() {

	}

	public void setCustomerRequirements(DataTransferObject dto) {

		this.dto = dto;

	}

	public Case getCase() {
		return case0;
	}

	public void complete() {
		case0=new Case();
		Customer customer;
		if (dto.getCustomer()!=null){
		customer = ServiceInitializer.getProvider().getCustomerService().findByUsername(dto.getCustomer().getUsername());
		if (customer==null)
			customer=new Customer();
		//Update Data
		customer.setFirstname(dto.getCustomer().getFirstName());
		customer.setLastname(dto.getCustomer().getLastName());
		customer.setUsername(dto.getCustomer().getUsername());
		customer.setPhone(dto.getCustomer().getPhone());		
		customer.setStreet(dto.getCustomer().getAddress().getStreet());
		customer.setStreetNumber(dto.getCustomer().getAddress().getStreetNumber());
		customer.setPostalCode(dto.getCustomer().getAddress().getPostalCode());		
		}
		else {
		customer = new Customer(dto.getCustomer().getFirstName(), dto
				.getCustomer().getLastName(), dto.getCustomer().getUsername(),
				dto.getCustomer().getPhone());
		customer.setStreet(dto.getCustomer().getAddress().getStreet());
		customer.setStreetNumber(dto.getCustomer().getAddress().getStreetNumber());
		customer.setPostalCode(dto.getCustomer().getAddress().getPostalCode());}
		case0.setCustomer(customer);
	}

}
