package de.wwu.wfm.sc4.capitol.service;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;

import de.wwu.wfm.sc4.capitol.data.Incident;

public class IncidentService extends AbstractServiceClass<Incident>{
	protected IncidentService() {
		super();
	}
	
	public List<Incident> findIncidentsWithReminderOlderThan(int days) {
		Session session = getSession();
		Query q = session.createQuery("from Incident i where "
				+" i.accidentReport is null"); // TODO date older than now - days
		return (List<Incident>)q.list();
	}
}
