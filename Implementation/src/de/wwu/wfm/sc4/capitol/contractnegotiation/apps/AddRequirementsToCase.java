package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.data.Requirements;

public class AddRequirementsToCase{
	private Requirements requirements;
	private Case case0;
	
	public void setRequirements(Requirements requirements){
		this.requirements = requirements;
	}
	
	public void setCase(Case case0){
		this.case0=case0;
	}
	
	public void complete(){
		case0.getRequirements().add(requirements);
		requirements.setCase0(case0);
	}

}