package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import java.util.ArrayList;
import java.util.Collection;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Customer;

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
		Customer cust = new Customer(dto.getCustomer().getFirstName(), dto
				.getCustomer().getLastName(), dto.getCustomer().getUsername(),
				dto.getCustomer().getPhone());
		cust.setStreet(dto.getCustomer().getAddress().getStreet());
		cust.setStreetNumber(dto.getCustomer().getAddress().getStreetNumber());
		cust.setPostalCode(dto.getCustomer().getAddress().getPostalCode());
		case0.setCustomer(cust);

		Collection<Car> cars = new ArrayList<Car>();
		for (int i = 0; i < dto.getContractData().getRequirements().getCars()
				.size(); i++)
			cars.add(new Car(dto.getContractData().getRequirements().getCars()
					.get(i).getLicensePlate(), dto.getContractData()
					.getRequirements().getCars().get(i).getType(), dto
					.getContractData().getRequirements().getCars().get(i)
					.getColor(), dto.getContractData().getRequirements()
					.getCars().get(i).getValue()));
		// TODO The collection "cars" is not assigned anywhere! What is it good for? 
		// Aren't cars part of the Requirements (and therefore not necessary/sensible here)?
		// Also, they will be part of the (final) contract, but not of the customer directly...
	}

}
