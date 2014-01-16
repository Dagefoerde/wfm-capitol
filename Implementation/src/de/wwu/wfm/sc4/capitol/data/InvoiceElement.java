package de.wwu.wfm.sc4.capitol.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
/**
 * represents an invoice element
 * got description and an amount
 * @author ben
 *
 */
import javax.persistence.Table;

@Entity
@Table(name = "invoice_element")
public class InvoiceElement extends AbstractDataClass {

	private static final long serialVersionUID = 12L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "description")
	private String description;

	@Column(name = "amount")
	private int amount;

	@OneToOne
	private Invoice invoice;

	public InvoiceElement() {

	}
	
	public InvoiceElement(String description, int amount){
		this.description = description;
		this.amount = amount;		
	}
	
	public int getId() {
		return id;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}



}
