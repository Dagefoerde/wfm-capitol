package de.wwu.wfm.sc4.msg.contractnegotiation.data;

import java.io.Serializable;

/**
 * Stores details on the car which are relevant for contract negotiation.
 * @author Jan
 *
 */
public class Car implements Serializable {
	
	/**
	 * please increment on every change!!
	 */
	private static final long serialVersionUID = 1L;
	
	
	private CarType carType;

	public Car(CarType carType) {
		if (carType == null) 
			throw new IllegalArgumentException();
		this.carType = carType;
	}

	public CarType getCarType() {
		return carType;
	}
}
