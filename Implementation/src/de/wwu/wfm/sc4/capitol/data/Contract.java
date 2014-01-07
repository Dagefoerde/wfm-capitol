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
	
	@OneToMany
	private Collection<Case> case0;
	// TODO: check relationship, contract does not store multiple incidents
	// right now
	@OneToOne
	private Incident incident;

	@OneToMany
	private Collection<Customer> customer;

	@OneToOne
	private Car car;

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public Collection<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(Collection<Customer> customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getId() {
		return id;
	}

}
