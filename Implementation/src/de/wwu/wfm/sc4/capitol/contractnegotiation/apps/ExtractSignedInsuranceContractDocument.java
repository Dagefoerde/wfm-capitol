package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import java.util.ArrayList;
import java.util.Collection;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Contract;

public class ExtractSignedInsuranceContractDocument {
	private DataTransferObject dto;
	private Case case0;
	private Contract contract;
	
	public void setDataTransferObject(DataTransferObject dto){
		this.dto = dto;
	}
	public void setCase(Case case0){
		this.case0 = case0;
	}
	
	public void complete(){
		contract= new Contract();
		contract.setCustomer(case0.getCustomer());
		Collection <Car> cars = new ArrayList<Car>();
		for(int i = 0; i<dto.getContractData().getRequirements().getCars().size(); i++)
			cars.add(new Car(dto.getContractData().getRequirements().getCars().get(i).getLicensePlate(),
					dto.getContractData().getRequirements().getCars().get(i).getType(), 
					dto.getContractData().getRequirements().getCars().get(i).getColor(), 
					dto.getContractData().getRequirements().getCars().get(i).getValue()));	
		contract.setCars(cars);
		contract.setHumanInsured(dto.getContractData().getRequirements().getHumanInsured());
		contract.setNaturalInsured(dto.getContractData().getRequirements().getNaturalInsured());
		contract.setPickupService(dto.getContractData().getRequirements().isPickUpService());
		contract.setSignedInsuranceContract(dto.getContractData().getInsuranceContract().getContractCapitol());
	}
	public Contract getContract(){
		return contract;
	}
}
