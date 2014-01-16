package de.wwu.wfm.sc4.capitol.exception;

public class CarNotFoundException extends RuntimeException {

	public CarNotFoundException(String string) {
		System.out.println(string);
	}

}
