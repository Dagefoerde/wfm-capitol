package de.wwu.wfm.sc4.capitol.service;

import java.util.ArrayList;
import java.util.Collection;

import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.data.Invoice;
import de.wwu.wfm.sc4.capitol.data.InvoiceElement;

public class InvoiceService extends AbstractServiceClass<Invoice> {
	protected InvoiceService() {
		super();
	}

	public Invoice findById(int id) {
		return findById(Invoice.class, id);
	}

	public Invoice createFromClaimData(ClaimData.ClaimData c, Incident incident) {
		Invoice invoice = new Invoice(c.getInvoice().getDate(), c.getInvoice()
				.getPointOfContact(), c.getInvoice().getDueSum(), c
				.getInvoice().getInvoiceNumber(), c.getInvoice()
				.getInvoiceText(), c.getInvoice().getPaymentTerm(), c
				.getInvoice().getBankAccount(), c.getInvoice().getBankName(), c
				.getInvoice().getBankCode(), c.getInvoice()
				.getBankAccountHolder(), incident, null);
		invoice.setInvoiceElements(convertFromDTOInvoiceElements(c.getInvoice()
				.getInvoiceElements(), invoice));
		return invoice;
	}

	private Collection<InvoiceElement> convertFromDTOInvoiceElements(
			Collection<ClaimData.InvoiceElement> invoiceElements,
			Invoice invoice) {
		Collection<InvoiceElement> list = new ArrayList<InvoiceElement>();
		for (ClaimData.InvoiceElement invoiceElement : invoiceElements) {
			list.add(ServiceInitializer.p().getInvoiceElementService()
					.convertFromDTOInvoiceElement(invoiceElement, invoice));
		}
		return list;
	}
}
