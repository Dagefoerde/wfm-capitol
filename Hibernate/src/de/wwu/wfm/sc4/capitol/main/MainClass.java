package de.wwu.wfm.sc4.capitol.main;

import java.util.Iterator;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.hibernate.HibernateUtil;
public class MainClass {

	public static void main(String[] args) {
		System.out.println("Hibernate example (Annotation)");
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
