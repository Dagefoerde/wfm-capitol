package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contract")
public class Contract extends AbstractDataClass {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@OneToOne
	private Case case0;
	
	@OneToMany
	private Collection<Incident> incident;

	@OneToOne
	private Customer customer;

	@OneToMany
	private Collection<Car> cars;
	
	public Case getCase0() {
		return case0;
	}

	public void setCase0(Case case0) {
		this.case0 = case0;
	}

	public Collection<Incident> getIncident() {
		return incident;
	}

	public void setIncident(Collection<Incident> incident) {
		this.incident = incident;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<Car> getCars() {
		return cars;
	}

	public void setCars(Collection<Car> cars) {
		this.cars = cars;
	}

	public int getId() {
		return id;
	}

}
