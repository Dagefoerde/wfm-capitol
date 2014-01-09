package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import java.util.List;

import de.wwu.wfm.sc4.capitol.data.Incident;

public class ReminderEmail {

	
	public void complete(List<Incident> incidents) {
		
		for(Incident incident : incidents) {
			synchronized (incident) { // work on db objects with mutual exclusion!
				// send email
				
				// update reminder date
				
				// update incident in db
				
			}
		}
	}
}
