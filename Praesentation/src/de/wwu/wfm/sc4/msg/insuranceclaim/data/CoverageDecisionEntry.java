package de.wwu.wfm.sc4.msg.insuranceclaim.data;

import java.io.Serializable;

/**
 * Describes a damage entry existing of a name and estimated costs.
 * 
 * @author Tobias
 */
public class CoverageDecisionEntry implements Serializable {

	/**
	 * please increment on every change!!
	 */
	private static final long serialVersionUID = 1L;
	
	private boolean isCovered;
	private String name;
	private Double costs;
	
	public CoverageDecisionEntry(String name, Double costs, boolean isCovered){
		if (name == null || costs ==null) 
			throw new IllegalArgumentException();
		this.setName(name);
		this.setCosts(costs);
		this.setCovered(isCovered);
	}

	public void setName(String name) {
		if (name == null) 
			throw new IllegalArgumentException();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setCosts(Double costs) {
		if (costs == null) 
			throw new IllegalArgumentException();
		this.costs = costs;
	}

	public Double getCosts() {
		return costs;
	}

	public void setCovered(boolean isCovered) {
		this.isCovered = isCovered;
	}

	public boolean isCovered() {
		return isCovered;
	}

}
