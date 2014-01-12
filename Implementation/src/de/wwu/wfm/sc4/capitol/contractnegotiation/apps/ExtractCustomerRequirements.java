package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import java.util.ArrayList;
import java.util.Collection;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Requirements;

public class ExtractCustomerRequirements {
	private DataTransferObject dto;
	private Requirements req;
	
	public void setDataTransferObject(DataTransferObject dto){
		this.dto = dto;
	}
	
	public void complete(){
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		req = new Requirements();
		
		Collection <Car> cars = new ArrayList<Car>();
		for(int i = 0; i<dto.getContractData().getRequirements().getCars().size(); i++)
			cars.add(new Car(dto.getContractData().getRequirements().getCars().get(i).getLicensePlate(),
					dto.getContractData().getRequirements().getCars().get(i).getType(), 
					dto.getContractData().getRequirements().getCars().get(i).getColor(), 
					dto.getContractData().getRequirements().getCars().get(i).getValue()));
		req.setCars(cars);
		req.setHumanInsured(dto.getContractData().getRequirements().getHumanInsured());
		req.setNaturalInsured(dto.getContractData().getRequirements().getNaturalInsured());
		req.setPickupService(dto.getContractData().getRequirements().isPickUpService());
	}
	public Requirements getCustomerRequirements(){
		return req;
	}
}
