package de.wwu.wfm.sc4.capitol.service;

import de.wwu.wfm.sc4.capitol.data.Invoice;
import de.wwu.wfm.sc4.capitol.data.InvoiceElement;

public class InvoiceElementService extends AbstractServiceClass<InvoiceElement> {

	public InvoiceElement convertFromDTOInvoiceElement(
			ClaimData.InvoiceElement invoiceElement, Invoice invoice) {
		return new InvoiceElement(invoiceElement.getDescription(),
				invoiceElement.getAmount(), invoice);
	}

}
