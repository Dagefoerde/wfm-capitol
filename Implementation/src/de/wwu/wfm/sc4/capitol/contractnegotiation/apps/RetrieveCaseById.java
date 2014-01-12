package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;


import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class RetrieveCaseById {
	private int caseID;
	
	public void setID(Integer id){
		caseID = id;
	}
	
	public Case complete(){
		return ServiceInitializer.getProvider().getCaseService().findById(caseID);
	}

}