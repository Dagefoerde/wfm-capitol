package de.wwu.wfm.sc4.capitol.service;

import java.util.Collection;

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
		// TODO
		/*
		 * Example
		 * Session s = getSession();
		 * s.save(A);
		 * s.getTransaction().commit();
		 * s.closeSession();
		 */
	}
	
	public A findById(int id){
		//TODO
		return null;
	}
	
	public Collection<A> findAll(){
		//TODO
		return null;
	}
}
