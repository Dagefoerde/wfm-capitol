package de.wwu.wfm.sc4.capitol.data;

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
@Table(name = "contract")
public class Contract extends AbstractDataClass {
	private static final long serialVersionUID = 3684205372429187300L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(unique = true)
	private int sharedContractId;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Case case0;
	
	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Incident> incident;

	@OneToOne(cascade = {CascadeType.ALL})
	private Customer customer;

	@OneToMany(cascade = {CascadeType.ALL})
	private Collection<Car> cars;
	
	@Column(name = "naturalInsured")
	private Double naturalInsured;
	
	@Column(name = "pickupService")
	private Boolean pickupService;
	
	@Column(name = "humanInsured")
	private Double humanInsured;
	
	@Column(name = "signedInsuranceContract")
	private byte[] signedInsuranceContract;
	
	public Case getCase0() {
		return case0;
	}

	public void setCase0(Case case0) {
		this.case0 = case0;
	}

	public Collection<Incident> getIncident() {
		return incident;
	}

	public void setIncident(Collection<Incident> incident) {
		this.incident = incident;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<Car> getCars() {
		return cars;
	}

	public void setCars(Collection<Car> cars) {
		this.cars = cars;
	}

	public int getId() {
		return id;
	}

	public void setNaturalInsured(Double naturalInsured) {
		this.naturalInsured = naturalInsured;
	}

	public Double getNaturalInsured() {
		return naturalInsured;
	}

	public void setPickupService(Boolean pickupService) {
		this.pickupService = pickupService;
	}

	public Boolean getPickupService() {
		return pickupService;
	}

	public void setHumanInsured(Double humanInsured) {
		this.humanInsured = humanInsured;
	}

	public Double getHumanInsured() {
		return humanInsured;
	}

	public void setSignedInsuranceContract(byte[] signedInsuranceContract) {
		this.signedInsuranceContract = signedInsuranceContract;
	}

	public byte[] getSignedInsuranceContract() {
		return signedInsuranceContract;
	}

	public void setSharedContractId(int sharedContractId) {
		this.sharedContractId = sharedContractId;
	}

	public int getSharedContractId() {
		return sharedContractId;
	}

}
