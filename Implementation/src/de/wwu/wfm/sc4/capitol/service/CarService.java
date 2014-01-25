package de.wwu.wfm.sc4.capitol.service;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Incident;

public class CarService extends AbstractServiceClass<Car> {
	protected CarService() {
		super();
	}

	public Car findById(int id) {
		return findById(Car.class, id);
	}

	public Car findByLicencePlate(String licencePlate) {
		Session s = ServiceInitializer.getProvider().getSession();
		Query q = s.createQuery("from Car c" +
				" where c.licencePlate = :licencePlate");
		q.setString("licencePlate", licencePlate);
		
		List<?> results = q.list();
		
		if (results.size() == 0) return null;
		return (Car)results.get(0);	
	}
}
