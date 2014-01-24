package de.wwu.wfm.sc4.capitol.service;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import de.wwu.wfm.sc4.capitol.data.Car;

public class CarService extends AbstractServiceClass<Car> {
	protected CarService() {
		super();
	}

	public Car findById(int id) {
		return findById(Car.class, id);
	}

	public Car findByLicencePlate(String licencePlate) {
		Session s = ServiceInitializer.getProvider().getSession();
		return (Car) s.createCriteria(Car.class).add(
				Restrictions.eq("licencePlate", licencePlate)).uniqueResult();
	}
}
