package de.wwu.wfm.sc4.capitol.test;

import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.service.CarService;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class RunTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Car c = new Car("licence", "big one", "red", 3.42);
		CarService cs = ServiceInitializer.getProvider().getCarService();
		cs.persist(c);
		cs.findById(1);
	}

}
