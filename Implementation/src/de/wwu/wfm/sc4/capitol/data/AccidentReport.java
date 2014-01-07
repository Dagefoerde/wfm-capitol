package de.wwu.wfm.sc4.capitol.data;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="accident_report")
public class AccidentReport extends AbstractDataClass{
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@OneToOne
	private Incident incident;

}
