package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;
import java.util.Collection;

public class Incident implements Serializable{

	private Collection<Contract> contract;

	private Collection<Car> car;

	private AccidentReport accidentReport;

	private DamageReport damageReport;

	private Invoice invoice;

}
