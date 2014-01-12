package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Contract;
import de.wwu.wfm.sc4.capitol.data.Customer;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class SaveSignedInsuranceContract {
	
	private Contract contract;
	
	public void setContract(Contract contract){
		this.contract=contract;
	}
	
	public void complete() {
		SimpleDateFormat df=new SimpleDateFormat("YYYYMMDD");
		String path="C:/WFM/contracts/"+df.format(new Date())+"-"+contract.getCustomer().getUsername()+contract.getCustomer().getContracts().size();
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
		ServiceInitializer.getProvider().getCaseService().persist(case0);
	}

}
