package de.wwu.wfm.sc4.capitol.data;

import java.util.List;

public class Contract {
	private int contractID;
	private List<Car> cars;
	
	
	public int getContractID() {
		return contractID;
	}
	public void setContractID(int contractID) {
		this.contractID = contractID;
	}
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
