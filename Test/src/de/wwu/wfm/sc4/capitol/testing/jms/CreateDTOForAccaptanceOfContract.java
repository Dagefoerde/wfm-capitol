package de.wwu.wfm.sc4.capitol.testing.jms;

import javax.jms.JMSException;

public class CreateDTOForAccaptanceOfContract {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main.main(new String[]{Main.Methods.createDTOForAccaptanceOfContract.toString()});
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
