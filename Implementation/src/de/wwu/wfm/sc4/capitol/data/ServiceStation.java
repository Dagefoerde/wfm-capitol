package de.wwu.wfm.sc4.capitol.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ServiceStation extends AbstractDataClass {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "phone")
	private String phone;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Address address;
	
	public ServiceStation(){
		
	}

	public ServiceStation(String phone, Address address) {
		super();
		this.phone = phone;
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getId() {
		return id;
	}
}
