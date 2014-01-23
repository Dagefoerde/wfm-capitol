package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import de.wwu.wfm.sc4.capitol.data.Case;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class ArchiveCase {
	private Case case0;
	
	public void setCase(Case case0){
		this.case0=case0;
	}
	public void complete(){
		case0.setNegotiationState(Case.NegotiationState.Terminated);
		ServiceInitializer.getProvider().getCaseService().persist(case0);
	}
}
