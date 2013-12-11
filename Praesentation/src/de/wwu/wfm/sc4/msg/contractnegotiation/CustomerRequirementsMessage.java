package de.wwu.wfm.sc4.msg.contractnegotiation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.wwu.wfm.sc4.msg.contractnegotiation.data.Car;
import de.wwu.wfm.sc4.msg.contractnegotiation.data.CustomerRequirement;
import de.wwu.wfm.sc4.msg.contractnegotiation.data.NewCustomer;

/**
 * Sent from BVIS to Capitol
 * (Contracting / Analyze Requirements) -> (ContractNeg / CR)
 * Contents: Customer Requirements, Customer incl. Car(s)
 * 
 * 
 * @author Jan
 */
public class CustomerRequirementsMessage implements Serializable {

	/**
	 * please increment on every change!!
	 */
	private static final long serialVersionUID = 1L;
	
	private NewCustomer newCustomerInformation;
	private List<Car> cars;
	private List<CustomerRequirement> customerRequirements;

	public CustomerRequirementsMessage(NewCustomer newCustomerInformation, Car car) {
		if (newCustomerInformation == null || car == null) 
			throw new IllegalArgumentException();
		
		this.newCustomerInformation = newCustomerInformation;
		
		this.cars = new ArrayList<Car>();
		this.cars.add(car);
		
		this.customerRequirements = new ArrayList<CustomerRequirement>();
		
	}
	
	public void addCar(Car car) {
		if (car == null) 
			throw new IllegalArgumentException();
		
		this.cars.add(car);
	}
	
	public List<Car> getCars() {
		return this.cars;
	}

	public void addCustomerRequirement(CustomerRequirement customerRequirement) {
		if (customerRequirement == null) 
			throw new IllegalArgumentException();
		
		this.customerRequirements.add(customerRequirement);
	}
	public List<CustomerRequirement> getCustomerRequirements() {
		return customerRequirements;
	}

	public NewCustomer getNewCustomerInformation() {
		return this.newCustomerInformation;
	}
}
