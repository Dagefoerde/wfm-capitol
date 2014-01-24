package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Customer;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class UpdateCustomer {

	private DataTransferObject dto;
	private Case case0;

	public UpdateCustomer() {

	}

	public void setDTO(DataTransferObject dto) {
		this.dto = dto;
	}

	public void setCase(Case case0) {
		this.case0 = case0;
	}

	public Case getCase() {
		return case0;
	}

	public void complete() {
		Customer customer;
		if (dto.getCustomer() != null) {
			customer = ServiceInitializer.getProvider().getCustomerService()
					.findByEmail(dto.getCustomer().geteMail());
			if (customer == null)
				customer = new Customer();
			// Update Data
			customer.setFirstname(dto.getCustomer().getFirstName());
			customer.setLastname(dto.getCustomer().getLastName());
			customer.setEMail(dto.getCustomer().geteMail());
			customer.setUsername(dto.getCustomer().getUsername());
			customer.setPhone(dto.getCustomer().getPhone());
			customer.setStreet(dto.getCustomer().getAddress().getStreet());
			customer.setStreetNumber(dto.getCustomer().getAddress()
					.getStreetNumber());
			customer.setPostalCode(dto.getCustomer().getAddress()
					.getPostalCode());
			customer.setCity(dto.getCustomer().getAddress().getCity());
		} else {
			customer = new Customer(dto.getCustomer().getFirstName(), dto
					.getCustomer().getLastName(), dto.getCustomer()
					.getUsername(), dto.getCustomer().getPhone());
			customer.setStreet(dto.getCustomer().getAddress().getStreet());
			customer.setStreetNumber(dto.getCustomer().getAddress()
					.getStreetNumber());
			customer.setPostalCode(dto.getCustomer().getAddress()
					.getPostalCode());
			customer.setEMail(dto.getCustomer().geteMail());
			customer.setCity(dto.getCustomer().getAddress().getCity());
		}
		case0.setCustomer(customer);
	}

}
