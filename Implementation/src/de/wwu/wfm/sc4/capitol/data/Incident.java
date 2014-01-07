package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;
import java.util.List;

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
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@OneToOne
	private Contract contract;
	// private Integer contractID;

	@OneToOne
	private Car car;
	// private Integer carID;

	@OneToOne(optional = true)
	private AccidentReport accidentReport;
	// private Integer accidentReportID;

	@OneToOne
	private DamageReport damageReport;
	// private Integer damageReportID;

	@OneToMany
	private List<Invoice> invoices;

	public Contract getContract() {
		if (contract != null)
			return contract;

		else {
			// TODO
			// contract = ContractService.getSingleton().getById(contractID);
			// return contract;
		}
		return null;
	}

	public void setContract(Contract c) {
		// TODO
		// contractID = c.getID();
		contract = c;
	}

	public List<Invoice> getInvoices() {
		if (invoices != null)
			return invoices;

		else {
			// incident is not saved yet, therefore there are no related
			// invoices!
			return null;
		}

		// TODO
		// invoices =
		// InvoiceService.getSingleton().getAllByIncidentId(incidentID);
		// return invoices;
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
	}

	public int getId() {
		return id;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

}
