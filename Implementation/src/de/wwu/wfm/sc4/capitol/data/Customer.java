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
@Table(name = "customer")
public class Customer extends AbstractDataClass {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@OneToMany
	private Collection<Case> case0;

	@OneToOne
	private Contract contract;

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
