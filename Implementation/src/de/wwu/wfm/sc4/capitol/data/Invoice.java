package de.wwu.wfm.sc4.capitol.data;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "invoice")
public class Invoice extends AbstractDataClass {

	@OneToOne
	private Incident incident;

}
