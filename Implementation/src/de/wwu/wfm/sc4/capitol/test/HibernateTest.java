package de.wwu.wfm.sc4.capitol.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.wwu.wfm.sc4.capitol.data.*;
import de.wwu.wfm.sc4.capitol.service.CarService;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class HibernateTest {

	public static void main(String[] args) {
		System.out.println("Hibernate Test");
		CarService cs = ServiceInitializer.getProvider().getCarService();
		Car c1 = new Car("bla");
		Car c2 = new Car("blub");

		cs.persist(c1);
		cs.persist(c2);
		
		System.out.println(cs.findById(Car.class,2));
		
		cs.closeSession();
	}
}
