package de.wwu.wfm.sc4.capitol.service;

import de.wwu.wfm.sc4.capitol.data.Contract;

public class ContractService extends AbstractServiceClass<Contract>{
	protected ContractService(){
		super();
	}
	
	public Contract findById(int id) {
		return findById(Contract.class, id);
	}
}
