package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import de.wwu.wfm.sc4.capitol.data.Invoice;

public class MakePayment {
	private Invoice invoice;

	private final String BANK_APP_IP = "http://wi-wfm10.uni-muenster.de:9999";
	private final String CAPITOL_ACCOUNT_NUMBER = "3";
	private final String BANK_APP_URL = BANK_APP_IP
			+ "/wfmbank/rest/account/add/tx?account=" + CAPITOL_ACCOUNT_NUMBER;
	private final String TO = "&to=";
	private final String AMOUNT = "&amount=";
	private final String DESCRIPTION = "&description=";

	public void complete() throws IOException {
		String description = Integer.toString(invoice.getInvoiceNumber());
		String paymentUrl = BANK_APP_URL + TO + invoice.getBankAccount()
				+ AMOUNT + invoice.getDueSum() + DESCRIPTION + description;
		System.out.println("Make Paymet with URL: "+paymentUrl);
		// TODO call URL and check response for okay
		String output=getURL(paymentUrl);
		System.out.println("Answer from Server");
		System.out.println(output);
		
	}
	public String getURL(String url) throws MalformedURLException, IOException {

		String proxy = "wi-proxy1.wi1.uni-muenster.de";
		String port = "8080";

		URL server = new URL(url);
		Properties systemProperties = System.getProperties();
		systemProperties.setProperty("http.proxyHost", proxy);
		systemProperties.setProperty("http.proxyPort", port);
		HttpURLConnection connection = (HttpURLConnection) server
				.openConnection();
		connection.connect();
		InputStream in = connection.getInputStream();

		return readString(in);
	}

	private String readString(InputStream is) throws IOException {
		char[] buf = new char[2048];
		Reader r = new InputStreamReader(is, "UTF-8");
		StringBuilder s = new StringBuilder();
		while (true) {
			int n = r.read(buf);
			if (n < 0) {
				break;
			}
			s.append(buf, 0, n);
		}
		return s.toString();
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
}
