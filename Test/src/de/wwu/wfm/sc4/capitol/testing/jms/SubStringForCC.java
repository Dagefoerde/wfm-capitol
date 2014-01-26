package de.wwu.wfm.sc4.capitol.testing.jms;

public class SubStringForCC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getInvoiceNumber("InvoiceNumber: 12312312312312"));
	}
	public static String getInvoiceNumber(String description){
		int index=description.lastIndexOf(": ");
		return description.substring(index+2);
	}
}
