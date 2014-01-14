package de.wwu.wfm.sc4.capitol.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice extends AbstractDataClass {
	private static final long serialVersionUID = -3101326277918755707L;

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
