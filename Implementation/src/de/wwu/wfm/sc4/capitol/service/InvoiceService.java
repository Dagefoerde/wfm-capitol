package de.wwu.wfm.sc4.capitol.service;

import de.wwu.wfm.sc4.capitol.data.Invoice;

public class InvoiceService extends AbstractServiceClass<Invoice> {
	protected InvoiceService(){
		super();
	}
	
	public Invoice findById(int id) {
		return findById(Invoice.class, id);
	}
}
