package de.wwu.wfm.sc4.capitol.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import de.wwu.wfm.sc4.capitol.data.Contract;

public class ContractService extends AbstractServiceClass<Contract>{
	protected ContractService(){
		super();
	}
	
	public Contract findById(int id) {
		return findById(Contract.class, id);
	}
	
	public Contract findBySharedId(int sharedContractId) {
		Session s = getSession();
		Query q = s.createQuery("from Contract c where c.sharedContractId = :id");
		q.setInteger("id", sharedContractId);
		
		List<?> list = q.list();
		if (list.size() == 0) return null;
		return (Contract)list.get(0);
		
	}
}
