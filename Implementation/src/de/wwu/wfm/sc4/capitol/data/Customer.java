package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends AbstractDataClass {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "username")
	private String username;

	@Column(name = "phone")
	private String phone;

	@Column(name = "street")
	private String street;

	@Column(name = "streetNumber")
	private int streetNumber;

	@Column(name = "postalCode")
	private String postalCode;

	@OneToMany
	private Collection<Case> cases;

	@OneToMany
	private Collection<Contract> contracts;

	public Customer(){
		this.cases=new ArrayList<Case>();
		this.contracts=new ArrayList<Contract>();
	}
	public Customer(String firstname, String lastname, String username,
			String phone) {
		this();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.phone = phone;
	}

	public Collection<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(Collection<Contract> contracts) {
		this.contracts = contracts;
	}

	public int getId() {
		return id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCases(Collection<Case> cases) {
		this.cases = cases;
	}

	public Collection<Case> getCases() {
		return cases;
	}

}
