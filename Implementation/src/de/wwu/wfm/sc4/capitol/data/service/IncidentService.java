package de.wwu.wfm.sc4.capitol.data.service;

import de.wwu.wfm.sc4.capitol.data.Incident;

public class IncidentService {
	private static IncidentService instance = null;
	
	public static IncidentService getSingleton() {
		if (instance == null) {
			instance = new IncidentService();
		}
		
		return instance;
	}
	
	private IncidentService() {
		super();
		// private in order to protect non-singleton invocation.
		// use getSingleton() instead. 
	}
	
	public Incident getByID(int id)  {
		// TODO retrieve incident from DB!
		
		return new Incident();
	}
	
	public void persist(Incident incident) {
		// TODO store in database, maybe update ID? if not done automatically by ORM...
		
	}
}
