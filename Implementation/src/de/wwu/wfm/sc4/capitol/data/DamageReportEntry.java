package de.wwu.wfm.sc4.capitol.data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "damage_report_entry")
public class DamageReportEntry extends AbstractDataClass {
	private static final long serialVersionUID = -5013844272346768457L;

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	private int position;
	private String description;
	private int costEstimation;
	private boolean coverageDecision;

	@ManyToOne(cascade = CascadeType.ALL)
	private DamageReport damageReport;

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCostEstimation() {
		return costEstimation;
	}

	public void setCostEstimation(int costEstimation) {
		this.costEstimation = costEstimation;
	}

	public boolean isCoverageDecision() {
		return coverageDecision;
	}

	public void setCoverageDecision(boolean coverageDecision) {
		this.coverageDecision = coverageDecision;
	}

	public int getId() {
		return id;
	}

	public void setDamageReport(DamageReport damageReport) {
		this.damageReport = damageReport;
	}

	public DamageReport getDamageReport() {
		return damageReport;
	}

	public Boolean getCoverageDecision() {
		return coverageDecision;
	}
}
