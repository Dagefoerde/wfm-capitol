package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requirements")
public class Requirements implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	// TODO: Relationships unclear
	private Collection<Case> case0;

	// TODO: Relationships unclear
	private Car car;

}
