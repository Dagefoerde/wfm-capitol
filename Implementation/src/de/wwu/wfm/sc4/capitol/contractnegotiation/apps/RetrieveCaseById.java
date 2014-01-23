package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;


import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class RetrieveCaseById {
	private int caseID;
	
	public void setID(Integer id){
		caseID = id;
	}
	
	public Case complete(){
		Case output= ServiceInitializer.getProvider().getCaseService().findById(caseID);
		if (output==null) System.out.println("WARNING - The Case with id \""+caseID+"\" is not in the database");
		return output;
	}

}