package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Contract;
import de.wwu.wfm.sc4.capitol.data.Requirements;

public class BuildInsuranceContract {
	
	private Case contractingCase;
	
	private Contract contract;
	
	private Requirements customerRequirements;
	
	public BuildInsuranceContract() {

	}
	public void setCustomerRequirements(Requirements customerRequirements){
		this.customerRequirements=customerRequirements;
	}
	public void setCase(Case contractingCase){
		this.contractingCase=contractingCase;
	}
	public void complete(){
		contract= new Contract();
		contract.setCars(customerRequirements.getCars());
		contract.setHumanInsured(customerRequirements.getHumanInsured());
		contract.setNaturalInsured(customerRequirements.getNaturalInsured());
		contract.setPickupService(customerRequirements.getPickupService());
		contract.setCase0(contractingCase);
	}
	public Contract getContract(){
		return contract;
	}
}
