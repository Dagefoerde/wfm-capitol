package de.wwu.wfm.sc4.capitol.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address extends AbstractDataClass {
	private static final long serialVersionUID = 7603202501301212412L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "streetNumber")
	private int streetNumber;

	@Column(name = "street")
	private String street;

	@Column(name = "postalCode")
	private String postalCode;
	
	@Column(name = "city")
	private String city;

	public Address() {

	}

	public Address(int streetNumber, String street, String postalCode,
			String city) {
		super();
		this.streetNumber = streetNumber;
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
