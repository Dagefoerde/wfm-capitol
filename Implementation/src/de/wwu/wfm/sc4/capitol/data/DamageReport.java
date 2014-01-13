package de.wwu.wfm.sc4.capitol.data;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "damage_report")
public class DamageReport extends AbstractDataClass {
	private static final long serialVersionUID = -6242945691078824168L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@OneToOne(mappedBy="damageReport", cascade=CascadeType.ALL)
	private Incident incident;
	
	@OneToMany(mappedBy="damageReport", cascade=CascadeType.ALL)
	private Collection<DamageReportEntry> entries;

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public int getId() {
		return id;
	}

	public void setEntries(Collection<DamageReportEntry> entries) {
		this.entries = entries;
	}

	public Collection<DamageReportEntry> getEntries() {
		return entries;
	}

}
