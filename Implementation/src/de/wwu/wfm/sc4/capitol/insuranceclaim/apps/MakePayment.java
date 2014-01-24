package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import de.wwu.wfm.sc4.capitol.data.Invoice;

public class MakePayment {
	private Invoice invoice;

	private final String BANK_APP_IP = "127.0.0.1";
	private final String CAPITOL_ACCOUNT_NUMBER = "1";
	private final String BANK_APP_URL = BANK_APP_IP
			+ "/wfmbank/rest/account/add/tx?account=" + CAPITOL_ACCOUNT_NUMBER;
	private final String TO = "&to=";
	private final String AMOUNT = "&amount=";
	private final String DESCRIPTION = "&description=";

	public void complete() throws IOException {
		String description = "Invoice #" + invoice.getInvoiceNumber() + " ("
				+ invoice.getDate().toString() + ")";
		String paymentUrl = BANK_APP_URL + TO + invoice.getBankAccount()
				+ AMOUNT + invoice.getDueSum() + DESCRIPTION + description;
		
		// TODO call URL and check response for okay
		URL url = new URL(paymentUrl);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.connect();
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
