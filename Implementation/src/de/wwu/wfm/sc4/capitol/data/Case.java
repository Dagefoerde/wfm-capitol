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

}
