package de.wwu.wfm.sc4.capitol.service;

import java.util.Collection;
import java.util.List;

import org.hibernate.Session;

import de.wwu.wfm.sc4.capitol.data.AbstractDataClass;

public class AbstractServiceClass<A extends AbstractDataClass> {
	
	public AbstractServiceClass(){
		super();
	}
	
	public Session getSession(){
		return ServiceInitializer.getProvider().getSession();
	}
	
	public void closeSession(){
		ServiceInitializer.getProvider().closeSession();
	}
	
	public void persist(A current){
		 Session s = getSession();
		 s.save(current);
		 s.getTransaction().commit();
		 s.close();
	}
	
	public A findById(Class<A> clazz, int id){
		Session s = getSession();
		A out = (A) s.get(clazz, id);
		s.close();
		return out;		
	}
	
	public Collection<A> findAll(Class<A> clazz){
		Session s = getSession();
		List<A> out = (List<A>) s.createCriteria(clazz).list();
		s.close();
		return out;
	}
}
