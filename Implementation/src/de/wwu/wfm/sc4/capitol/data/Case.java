package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "case")
public class Case extends AbstractDataClass {
	// TODO Relationships are unclear
	@OneToOne
	private Customer customer;

	@OneToOne
	private Requirements requirements;

	@OneToOne
	private Contract contract;

}
