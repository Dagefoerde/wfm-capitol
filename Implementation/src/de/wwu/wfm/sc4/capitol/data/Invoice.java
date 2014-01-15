package de.wwu.wfm.sc4.capitol.data;

import java.util.Date;

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

	@Column(name = "date")
	private Date date;

	@Column(name = "pointOfContact")
	private String pointOfContact;

	@Column(name = "dueSum")
	private double dueSum;

	@Column(name = "invoiceNumber")
	private int invoiceNumber;

	@Column(name = "invoiceText")
	private String invoiceText;

	@Column(name = "paymentTerm")
	private Date paymentTerm;

	@Column(name = "bankAccount")
	private String bankAccount;

	@Column(name = "bankName")
	private String bankName;

	@Column(name = "bankCode")
	private String bankCode;

	@Column(name = "bankAccountHolder")
	private String bankAccountHolder;

	@OneToOne
	private Incident incident;

	public Invoice(Date date, String pointOfContact, double dueSum,
			int invoiceNumber, String invoiceText, Date paymentTerm,
			String bankAccount, String bankName, String bankCode,
			String bankAccountHolder, Incident incident) {
		super();
		this.date = date;
		this.pointOfContact = pointOfContact;
		this.dueSum = dueSum;
		this.invoiceNumber = invoiceNumber;
		this.invoiceText = invoiceText;
		this.paymentTerm = paymentTerm;
		this.bankAccount = bankAccount;
		this.bankName = bankName;
		this.bankCode = bankCode;
		this.bankAccountHolder = bankAccountHolder;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPointOfContact() {
		return pointOfContact;
	}

	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}

	public double getDueSum() {
		return dueSum;
	}

	public void setDueSum(double dueSum) {
		this.dueSum = dueSum;
	}

	public int getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceText() {
		return invoiceText;
	}

	public void setInvoiceText(String invoiceText) {
		this.invoiceText = invoiceText;
	}

	public Date getPaymentTerm() {
		return paymentTerm;
	}

	public void setPaymentTerm(Date paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankAccountHolder() {
		return bankAccountHolder;
	}

	public void setBankAccountHolder(String bankAccountHolder) {
		this.bankAccountHolder = bankAccountHolder;
	}

	public double getTotal() {
		return getDueSum();
	}

	public double getEstimatedTotal() throws Exception {
		if (incident == null) {
			throw new Exception("Invoice is not connected to an incident.");
		}
		DamageReport damageReport = incident.getDamageReport();
		if (damageReport == null) {
			throw new Exception("DamageReport is not existent in incident.");
		}
		double estimatedTotal = 0;

		for (DamageReportEntry d : damageReport.getEntries()) {
			estimatedTotal += d.getCostEstimation();
		}
		return estimatedTotal;
	}

}
