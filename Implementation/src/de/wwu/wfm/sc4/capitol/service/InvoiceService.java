package de.wwu.wfm.sc4.capitol.service;

import ClaimData.ClaimData;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.data.Invoice;

public class InvoiceService extends AbstractServiceClass<Invoice> {
	protected InvoiceService() {
		super();
	}

	public Invoice findById(int id) {
		return findById(Invoice.class, id);
	}

	public Invoice createFromClaimData(ClaimData c, Incident incident) {
		return new Invoice(c.getInvoice().getDate(), c.getInvoice()
				.getPointOfContact(), c.getInvoice().getDueSum(), c
				.getInvoice().getInvoiceNumber(), c.getInvoice()
				.getInvoiceText(), c.getInvoice().getPaymentTerm(), c
				.getInvoice().getBankAccount(), c.getInvoice().getBankName(), c
				.getInvoice().getBankCode(), c.getInvoice()
				.getBankAccountHolder(), incident);
	}
}
