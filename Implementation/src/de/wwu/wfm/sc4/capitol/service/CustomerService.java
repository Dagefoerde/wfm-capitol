package de.wwu.wfm.sc4.capitol.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import de.wwu.wfm.sc4.capitol.data.Customer;

public class CustomerService extends AbstractServiceClass<Customer> {
	protected CustomerService(){
		super();
	}
	
	public Customer findById(int id) {
		return findById(Customer.class, id);
	}

	public Customer findByUsername(String username) {
		if (username == null) throw new IllegalArgumentException("Username may not be null.");
		// TODO depending on which one is guaranteed to unique, leave as username or change to eMail.
		
		Session s = getSession();
		Query q = s.createQuery("from Customer c where c.username = :username");
		q.setString("username", username);
		
		List<?> list = q.list();
		if (list.size() == 0) return null;
		return (Customer)list.get(0);
		
	}
	public Customer findByEmail(String email) {
		if (email == null) throw new IllegalArgumentException("Email may not be null.");
		
		Session s = getSession();
		Query q = s.createQuery("from Customer c where c.eMail = :email");
		q.setString("email", email);
		
		List<?> list = q.list();
		if (list.size() == 0) return null;
		return (Customer)list.get(0);
		
	}
}
