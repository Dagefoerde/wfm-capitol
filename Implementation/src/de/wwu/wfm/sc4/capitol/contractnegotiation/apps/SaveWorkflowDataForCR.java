package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;
import de.wwu.wfm.sc4.capitol.data.Requirements;
import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Contract;

import java.util.*;

public class SaveWorkflowDataForCR {
	private Case case0;
	
	public void setCase(Case case0){
		this.case0=case0;
	}
	public void complete(){
		ServiceInitializer.getProvider().getCaseService().persist(case0);
		
		/*ServiceInitializer.getProvider().getCustomerService().persist(case0.getCustomer());
		
		Collection<Requirements> reqs = case0.getRequirements();
		Requirements currentReq = null;
		Iterator<Requirements> iteratorReq =reqs.iterator();
		while (iteratorReq.hasNext())
		currentReq=iteratorReq.next();
		ServiceInitializer.getProvider().getRequirementsService().persist(currentReq);
		
		
		Collection<Car> cars = currentReq.getCars();
		Car currentCar = null;
		Iterator<Car> iteratorCar =cars.iterator();
		while (iteratorCar.hasNext())
		currentCar = iteratorCar.next();
		ServiceInitializer.getProvider().getCarService().persist(currentCar);
		
		
		Collection<Contract> cons = case0.getContract();
		Contract currentCon = null;
		Iterator<Contract> iteratorCon = cons.iterator();
		while (iteratorCon.hasNext())
		currentCon=iteratorCon.next();
		ServiceInitializer.getProvider().getContractService().persist(currentCon);*/
	}

}
