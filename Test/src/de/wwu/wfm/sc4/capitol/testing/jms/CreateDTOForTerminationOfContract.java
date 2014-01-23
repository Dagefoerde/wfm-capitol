package de.wwu.wfm.sc4.capitol.testing.jms;

import javax.jms.JMSException;

public class CreateDTOForTerminationOfContract {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Main.main(new String[]{Main.Methods.createDTOForTerminationOfContract.toString()});
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
