package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import java.util.List;

import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.IncidentService;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class RetrieveCandidateIncidents {

	
	public List<Incident> complete() {
		/**
		 * "Candidates" are those incidents, where either
		 * 1) 8 days have passed since the accident (first reminder), or
		 * 2) 8 days have passed since the last reminder
		 * AND no accident report was received yet.
		 */
		IncidentService service = ServiceInitializer.p().getIncidentService();
		return service.findIncidentsWithReminderOlderThan(8);
	}
}
