package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class AbstractDataClass implements Serializable {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;

}
