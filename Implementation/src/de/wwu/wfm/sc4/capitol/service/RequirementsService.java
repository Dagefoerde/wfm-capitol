package de.wwu.wfm.sc4.capitol.service;

import de.wwu.wfm.sc4.capitol.data.Requirements;

public class RequirementsService extends AbstractServiceClass<Requirements> {
	protected RequirementsService(){
		super();
	}
	
	public Requirements findById(int id) {
		return findById(Requirements.class, id);
	}
}
