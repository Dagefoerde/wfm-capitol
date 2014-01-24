package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import DTO.DataTransferObject;

import de.wwu.wfm.sc4.capitol.constants.CapitolConstants;
import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Contract;
import de.wwu.wfm.sc4.capitol.data.Customer;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class AcceptContract {
	
	private Case case0;
	private DataTransferObject dto;
	
	public void setCase(Case case0){
		this.case0=case0;
	}
	
	public void setDTO(DataTransferObject dto){
		this.dto=dto;
	}
	
	public void complete() {
		Contract contract=(Contract) case0.getContract().toArray()[case0.getContract().size()-1];
		contract.setCustomer(case0.getCustomer());
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMDD");
		String fileName=contract.getPath();
		String path=CapitolConstants.CONTRACTS_PATH+"/"+fileName;
		for (Car car:contract.getCars()){
			car.setContract(contract);
		}
		FileOutputStream output;
		try {
			output = new FileOutputStream(path);
			output.write(contract.getSignedInsuranceContract());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ServiceInitializer.getProvider().getContractService().persist(contract);
		Customer customer=contract.getCustomer();
		Collection<Contract> coll=customer.getContracts()==null?new ArrayList<Contract>():customer.getContracts();
		coll.add(contract);
		customer.setContracts(coll);
		ServiceInitializer.getProvider().getCustomerService().persist(customer);
		Case case0=contract.getCase0();
		case0.setNegotiationState(Case.NegotiationState.Accepted);
		// TODO save flag for contract, stating that it is accepted!
		ServiceInitializer.getProvider().getCaseService().persist(case0);
	}

}
