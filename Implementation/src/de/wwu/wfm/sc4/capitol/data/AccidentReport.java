package de.wwu.wfm.sc4.capitol.data;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name = "accident_report")
public class AccidentReport extends AbstractDataClass {
	private static final long serialVersionUID = -2225878572380026288L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	private Address crashAddress;
	private Date date;
	private Customer customer;
	private Car car;
	private String cause;
	private String description;
	private boolean isMaintenace;
	private boolean needsTow;

	@OneToOne(cascade = {CascadeType.ALL})
	private Incident incident;

	public AccidentReport() {
	}

	public AccidentReport(Address crashAddress, Date date, Customer customer,
			Car car, String cause, String description, boolean isMaintenance,
			boolean needsTow, Incident incident) {
		this.crashAddress = crashAddress;
		this.date = date;
		this.customer = customer;
		this.car = car;
		this.cause = cause;
		this.description = description;
		this.isMaintenace = isMaintenance;
		this.needsTow = needsTow;
		this.incident = incident;
	}

	public Incident getIncident() {
		return incident;
	}

	public void setIncident(Incident incident) {
		this.incident = incident;
	}

	public int getId() {
		return id;
	}

	public Address getCrashAddress() {
		return crashAddress;
	}

	public void setCrashAddress(Address crashAddress) {
		this.crashAddress = crashAddress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isMaintenace() {
		return isMaintenace;
	}

	public void setMaintenace(boolean isMaintenace) {
		this.isMaintenace = isMaintenace;
	}

	public boolean isNeedsTow() {
		return needsTow;
	}

	public void setNeedsTow(boolean needsTow) {
		this.needsTow = needsTow;
	}

}
