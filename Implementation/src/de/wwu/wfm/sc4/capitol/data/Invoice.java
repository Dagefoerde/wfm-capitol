package de.wwu.wfm.sc4.capitol.data;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

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

	@OneToOne(cascade = { CascadeType.ALL })
	private Incident incident;

	@OneToMany(cascade = { CascadeType.ALL })
	private Collection<InvoiceElement> invoiceElements;
	
	@Type(type="org.hibernate.type.PrimitiveByteArrayBlobType") 
	@Column(name = "InvoiceDocument")
	private byte[] invoiceDocument;
	
	@Column(name = "path")
	private String path;

	public Invoice() {
		super();
	}

	public Invoice(Date date, String pointOfContact, double dueSum,
			int invoiceNumber, String invoiceText, Date paymentTerm,
			String bankAccount, String bankName, String bankCode,
			String bankAccountHolder, Incident incident,
			Collection<InvoiceElement> invoiceElements) {
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
		this.invoiceElements = invoiceElements;
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

	public int getEstimatedTotal() throws Exception {
		if (incident == null) {
			throw new Exception("Invoice is not connected to an incident.");
		}
		DamageReport damageReport = incident.getDamageReport();
		if (damageReport == null) {
			throw new Exception("DamageReport is not existent in incident.");
		}

		return damageReport.getEstimatedTotal();
	}

	public void setInvoiceElements(Collection<InvoiceElement> invoiceElements) {
		this.invoiceElements = invoiceElements;
	}

	public Collection<InvoiceElement> getInvoiceElements() {
		return invoiceElements;
	}

	public boolean hasPositionsNotCovered() {
		boolean checkResult = false;
		Collection<DamageReportEntry> damageReportEntries = this.incident
				.getDamageReport().getEntries();
		
		// check for different collection sizes
		if (damageReportEntries.size() != this.invoiceElements.size())
			checkResult = false;
		else {
		// check for not covered elements
			int countListElements = this.invoiceElements.size();
			for (InvoiceElement ie : this.invoiceElements) {
				for (DamageReportEntry dre : damageReportEntries) {
					if (ie.getDescription().equals(dre.getDescription())) {
						countListElements--;
						if (dre.getCoverageDecision() == false) {
							checkResult = false;
						}
					}
				}
			}
		//check for correct entries
		if(countListElements != 0)
			checkResult = false;
		}
		return checkResult;
	}
	
	public void setInvoiceDocument(byte[] invoiceDocument) {
		this.invoiceDocument = invoiceDocument;
	}

	public byte[] getInvoiceDocument() {
		return invoiceDocument;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	public String getPath() {
		return path;
	}
}
