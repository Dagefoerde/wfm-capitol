package de.wwu.wfm.sc4.capitol.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	public Address() {

	}

	public Address(int a, String b, String c) {
		this.streetNumber = a;
		this.street = b;
		this.postalCode = c;
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
}
