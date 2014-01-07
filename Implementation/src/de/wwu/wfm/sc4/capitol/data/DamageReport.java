package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "damage_report")
public class DamageReport extends AbstractDataClass {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@OneToOne
	private Incident incident;

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public int getId() {
		return id;
	}

}
