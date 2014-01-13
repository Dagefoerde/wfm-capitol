package de.wwu.wfm.sc4.capitol.data;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "incident")
public class Incident extends AbstractDataClass {
	private static final long serialVersionUID = 6374331148916365902L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	/**
	 * Stores the ID that identifies an incident across the company's boundaries
	 */
	@Column(unique = true)
	private int sharedIncidentID;

	@OneToOne
	private Contract contract;

	@OneToOne
	private Car car;

	@OneToOne(optional = true)
	private AccidentReport accidentReport;

	@OneToOne(cascade=CascadeType.ALL)
	private DamageReport damageReport;

	@OneToMany
	private List<Invoice> invoices;

	private Date lastReminder;

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract c) {
		contract = c;
	}

	public List<Invoice> getInvoices() {
		return invoices;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public AccidentReport getAccidentReport() {
		return accidentReport;
	}

	public void setAccidentReport(AccidentReport accidentReport) {
		this.accidentReport = accidentReport;
	}

	public DamageReport getDamageReport() {
		return damageReport;
	}

	public void setDamageReport(DamageReport damageReport) {
		this.damageReport = damageReport;
		damageReport.setIncident(this);
	}

	public int getId() {
		return id;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	public void setLastReminder(Date lastReminder) {
		this.lastReminder = lastReminder;
	}

	public Date getLastReminder() {
		return lastReminder;
	}

	public void setSharedIncidentID(int sharedIncidentID) {
		this.sharedIncidentID = sharedIncidentID;
	}

	public int getSharedIncidentID() {
		return sharedIncidentID;
	}

}
