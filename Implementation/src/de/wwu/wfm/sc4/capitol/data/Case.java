package de.wwu.wfm.sc4.capitol.data;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contractcase")
public class Case extends AbstractDataClass {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@OneToOne
	private Customer customer;

	@OneToMany
	private Collection<Requirements> requirements;

	@OneToMany
	private Collection<Contract> contracts;

	public Case(){
		requirements=new ArrayList<Requirements>();
		contracts=new ArrayList<Contract>();
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public Collection<Requirements> getRequirements() {
		return requirements;
	}

	public void setRequirements(Collection<Requirements> requirements) {
		this.requirements = requirements;
	}

	public Collection<Contract> getContract() {
		return contracts;
	}

	public void setContract(Collection<Contract> contract) {
		this.contracts = contract;
	}

}
