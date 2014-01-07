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
@Table(name = "car")
public class Car extends AbstractDataClass {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	// TODO: Relationships unclear
	@OneToMany
	private Collection<Requirements> requirements;

	// TODO check Relationship: Car does not store related incidents
	@OneToOne
	private Incident incident;

	@OneToMany
	private Collection<Contract> contract;

	public Car() {

	}

	public Car(String name) {
		this.name = name;
	}

}
