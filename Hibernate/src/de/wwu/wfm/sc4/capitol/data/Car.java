package de.wwu.wfm.sc4.capitol.data;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Car")
public class Car {
	@Id
	@GeneratedValue
	@Column(name="car_id")
	private int carID;
	@Column(name="name")
	private String name;
	
	public Car(){
		
	}
	
	public Car(String name){
		this.name = name;
	}
	public void setId(int carID) {
		this.carID = carID;
	}

	public int getId() {
		return carID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
}
