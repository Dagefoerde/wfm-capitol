package de.wwu.wfm.sc4.capitol.data;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "contractcase")
public class Case extends AbstractDataClass {
	private static final long serialVersionUID = -5614119743408419861L;

	@Id
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = {CascadeType.ALL})
	private Customer customer;

	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Requirements> requirements;

	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Contract> contracts;
	
	@Column(name="negotiationState")
	private NegotiationState negotiationState;
	
	public static enum NegotiationState{
		inNegotiation,Terminated,Accepted;
	}

	public Case(){
		requirements=new ArrayList<Requirements>();
		contracts=new ArrayList<Contract>();
		negotiationState=NegotiationState.inNegotiation;
	}
	
	public Case(int id){
		this();
		this.id=id;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public Collection<Requirements> getRequirements() {
		return requirements;
	}

	public void setRequirements(Collection<Requirements> requirements) {
		this.requirements = requirements;
	}

	public Collection<Contract> getContract() {
		return contracts;
	}

	public void setContract(Collection<Contract> contract) {
		this.contracts = contract;
	}

	public void setNegotiationState(NegotiationState negotiationState) {
		this.negotiationState = negotiationState;
	}

	public NegotiationState getNegotiationState() {
		return negotiationState;
	}

}
