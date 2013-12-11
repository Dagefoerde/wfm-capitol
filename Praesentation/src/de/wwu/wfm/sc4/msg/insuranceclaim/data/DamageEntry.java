package de.wwu.wfm.sc4.msg.insuranceclaim.data;

import java.io.Serializable;

/**
 * Describes a damage entry existing of a name and estimated costs.
 * 
 * @author Tobias
 */
public class DamageEntry implements Serializable {

	/**
	 * please increment on every change!!
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Double costs;
	
	public DamageEntry(String name, Double costs){
		this.setName(name);
		this.setCosts(costs);
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCosts(Double costs) {
		this.costs = costs;
	}

	public Double getCosts() {
		return costs;
	}

}
