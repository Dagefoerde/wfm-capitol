package de.wwu.wfm.sc4.capitol.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.wwu.wfm.sc4.capitol.data.*;

public class HibernateTest {

	public static void main(String[] args) {
		System.out.println("Hibernate Test");
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Car c1 = new Car("bla");
		Car c2 = new Car("blub");

		session.save(c1);
		session.save(c2);
		session.getTransaction().commit();
		session.close();

	}
}
