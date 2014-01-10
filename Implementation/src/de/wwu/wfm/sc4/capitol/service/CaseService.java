package de.wwu.wfm.sc4.capitol.service;

import de.wwu.wfm.sc4.capitol.data.Case;

public class CaseService extends AbstractServiceClass<Case> {
	protected CaseService(){
		super();
	}

	public Case findById(int id) {
		return findById(Case.class, id);
	}
}
