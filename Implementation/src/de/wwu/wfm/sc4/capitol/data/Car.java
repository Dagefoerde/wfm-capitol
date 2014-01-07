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
public class Car implements Serializable {
	// TODO: Relationships unclear
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@OneToMany
	private Collection<Requirements> requirements;

	// TODO check Relationship: Car does not store related incidents
	@OneToOne
	private Incident incident;

	@OneToMany
	private Collection<Contract> contract;

}
