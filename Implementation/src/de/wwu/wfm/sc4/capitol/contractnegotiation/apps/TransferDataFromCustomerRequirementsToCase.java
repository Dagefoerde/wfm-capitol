package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Customer;
import de.wwu.wfm.sc4.capitol.data.Contract;
import de.wwu.wfm.sc4.capitol.data.Requirements;
import DTO.DataTransferObject;

import java.util.ArrayList;
import java.util.Collection;

public class TransferDataFromCustomerRequirementsToCase {
	
	private DataTransferObject dto;
	private Case case0;
	
	
	public TransferDataFromCustomerRequirementsToCase(){
		
		
		
	}
	public void setCustomerRequirements(DataTransferObject dto ){
		
		this.dto = dto;
		
	}
	public Case getCase(){
		return case0;		
	}
	public void complete(){
		Customer cust = new Customer (dto.getCustomer().getFirstName(), dto.getCustomer().getLastName(), dto.getCustomer().getUsername(), dto.getCustomer().getPhone());
		cust.setStreet(dto.getCustomer().getAddress().getStreet());
		cust.setStreetNumber(dto.getCustomer().getAddress().getStreetNumber());
		cust.setPostalCode(dto.getCustomer().getAddress().getPostalCode());
		case0.setCustomer(cust);
		
		
		Collection <Car> cars = new ArrayList<Car>();
		for(int i = 0; i<dto.getContractData().getRequirements().getCars().size(); i++)
			cars.add(new Car(dto.getContractData().getRequirements().getCars().get(i).getLicensePlate(),
					dto.getContractData().getRequirements().getCars().get(i).getType(), 
					dto.getContractData().getRequirements().getCars().get(i).getColor(), 
					dto.getContractData().getRequirements().getCars().get(i).getValue()));
		
		Requirements req = new Requirements();
		req.setCars(cars);
		req.setHumanInsured(dto.getContractData().getRequirements().getHumanInsured());
		req.setNaturalInsured(dto.getContractData().getRequirements().getNaturalInsured());
		req.setPickupService(dto.getContractData().getRequirements().isPickUpService());
		req.setCase0(this.case0);
		Collection <Requirements>reqs = new ArrayList<Requirements>();
		reqs.add(req);
		case0.setRequirements(reqs);
		
		
		Contract con = new Contract();
		con.setCase0(this.case0);
		con.setCustomer(case0.getCustomer());
		con.setCars(cars);
			
		con.setHumanInsured(dto.getContractData().getRequirements().getHumanInsured());
		con.setNaturalInsured(dto.getContractData().getRequirements().getNaturalInsured());
		con.setPickupService(dto.getContractData().getRequirements().isPickUpService());
		Collection<Contract> cons= new ArrayList<Contract>();
		cons.add(con);
		case0.setContract(cons);
		cust.setContract(con);
	}

}
