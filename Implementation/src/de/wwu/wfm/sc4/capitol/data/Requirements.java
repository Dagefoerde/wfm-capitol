package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requirements")
public class Requirements extends AbstractDataClass {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@OneToOne
	private Case case0;

	@OneToMany
	private Collection<Car> cars;
	
	@Column(name = "naturalInsured")
	private Boolean naturalInsured;
	
	@Column(name = "pickupService")
	private Boolean pickupService;
	
	@Column(name = "humanInsured")
	private Double humanInsured;

	public Requirements() {

	}

	public int getId() {
		return id;
	}

	public Case getCase0() {
		return case0;
	}

	public void setCase0(Case case0) {
		this.case0 = case0;
	}

	public Collection<Car> getCars() {
		return cars;
	}

	public void setCars(Collection<Car> cars) {
		this.cars = cars;
	}

	public void setNaturalInsured(Boolean naturalInsured) {
		this.naturalInsured = naturalInsured;
	}

	public Boolean getNaturalInsured() {
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

}
