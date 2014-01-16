package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import java.util.Date;
import java.util.List;

import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class ReminderEmail {

	
	public void complete(List<Incident> incidents) {
		
		for(Incident incident : incidents) {
				// TODO send email
				
				incident.setLastReminder(new Date());
				ServiceInitializer.getProvider().getIncidentService().persist(incident);
		}
	}
}
