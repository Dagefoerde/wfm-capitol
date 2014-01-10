package de.wwu.wfm.sc4.capitol.service;

import de.wwu.wfm.sc4.capitol.data.Car;

public class CarService extends AbstractServiceClass<Car> {
	protected CarService() {
		super();
	}

	public Car findById(int id) {
		return findById(Car.class, id);
	}
}
