package de.wwu.wfm.sc4.capitol.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import de.wwu.wfm.sc4.capitol.data.Incident;

public class IncidentService extends AbstractServiceClass<Incident> {
	protected IncidentService() {
		super();
	}

	public Incident findById(int id) {
		return findById(Incident.class, id);
	}
	
	public Incident findBySharedId(int sharedId) {
		Session s = getSession();
		Query q = s.createQuery("from Incident i" +
				" where i.sharedIncidentID = :id");
		q.setInteger("id", sharedId);
		
		List<?> results = q.list();
		
		if (results.size() == 0) return null;
		return (Incident)results.get(0);		
	}

	public List<Incident> findIncidentsWithReminderOlderThan(int days) {
		if (days < 0)
			throw new IllegalArgumentException(
					"Argument 'days' needs to be positive or zero.");

		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.add(Calendar.DAY_OF_YEAR, -days);
		Date daysLowerBound = cal.getTime();

		Session session = getSession();
		Query q = session.createQuery("from Incident i where "
				+ " i.accidentReport is null and "
				+ " i.lastReminder >= :daysLowerBound");
		q.setDate("daysLowerBound", daysLowerBound);

		return (List<Incident>) q.list();
	}
}
