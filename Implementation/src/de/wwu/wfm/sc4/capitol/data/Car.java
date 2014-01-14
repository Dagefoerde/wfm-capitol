package de.wwu.wfm.sc4.capitol.data;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car extends AbstractDataClass {
	private static final long serialVersionUID = 7913323976741736959L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "licencePlate")
	private String licencePlate;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "color")
	private String color;

	@Column(name = "buyingPrice")
	private Double buyingPrice;
	
	@OneToOne
	private Requirements requirements;

	@OneToMany
	private Collection<Incident> incident;

	@OneToOne
	private Contract contract;

	public Car() {

	}
	
	public Car(String licencePlate){
		this.licencePlate=licencePlate;
	}
	public Car(String licencePlate,String type,String color,Double buyingPrice) {
		this.licencePlate = licencePlate;
		this.type=type;
		this.color=color;
		this.buyingPrice=buyingPrice;
	}

	public String getLicencePlate() {
		return licencePlate;
	}

	public void setName(String licencePlate) {
		this.licencePlate = licencePlate;
	}

	public int getId() {
		return id;
	}

	public Requirements getRequirements() {
		return requirements;
	}

	public void setRequirements(Requirements requirements) {
		this.requirements = requirements;
	}

	public Collection<Incident> getIncident() {
		return incident;
	}

	public void setIncident(Collection<Incident> incident) {
		this.incident = incident;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBuyingPrice(Double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	public Double getBuyingPrice() {
		return buyingPrice;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

}
