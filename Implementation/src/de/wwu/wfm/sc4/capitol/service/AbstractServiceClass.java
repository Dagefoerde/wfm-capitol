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
	
	public Object persist(A current){
		 Session s = getSession();
		 s.beginTransaction();
		 Object o = s.merge(current);
		 s.getTransaction().commit();
		 return o;
	}
	
	public A findById(Class<A> clazz, int id){
		Session s = getSession();
		A out = (A) s.get(clazz, id);
		return out;		
	}
	
	public Collection<A> findAll(Class<A> clazz){
		Session s = getSession();
		List<A> out = (List<A>) s.createCriteria(clazz).list();
		return out;
	}
}
