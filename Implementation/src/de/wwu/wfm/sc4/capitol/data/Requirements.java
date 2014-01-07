package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "requirements")
public class Requirements extends AbstractDataClass {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	// TODO: Relationships unclear, var identifier "case" produces issues /w
	// hibernate
	// private Collection<Case> case;

	// TODO: Relationships unclear
	private Car car;

	public Requirements() {

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
