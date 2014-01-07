package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "case")
public class Case extends AbstractDataClass {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	// TODO Relationships are unclear
	@OneToOne
	private Customer customer;

	@OneToOne
	private Requirements requirements;

	@OneToOne
	private Contract contract;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Requirements getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public int getId() {
		return id;
	}

}
