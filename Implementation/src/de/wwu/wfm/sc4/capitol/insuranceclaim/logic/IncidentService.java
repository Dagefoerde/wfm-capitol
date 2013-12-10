package de.wwu.wfm.sc4.capitol.insuranceclaim.logic;

import de.wwu.wfm.sc4.capitol.data.Incident;

public class IncidentService {
	public Incident getByID(int id)  {
		// TODO retrieve incident from DB!
		
		return new Incident();
	}
	
	public void persist(Incident incident) {
		// TODO store in database, maybe update ID? if not done automatically by ORM...
		
	}
}
