package de.wwu.wfm.sc4.msg.insuranceclaim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.wwu.wfm.sc4.msg.insuranceclaim.data.DamageEntry;

	/**
	 * Sent from Cars&Co via BVIS to Capitol
	 * (Processing the vehicle / ) -> (Claim Handling / Damage Report Handling) -> (Insurance claim / Record Incident)
	 * Contents: Damage Report, Cost estimation, Case
	 * 
	 * 
	 * @author Tobias
	 */
	public class DamageReportMessage implements Serializable {

		/**
		 * please increment on every change!!
		 */
		private static final long serialVersionUID = 1L;
		
		private String caseID;
		private List<DamageEntry> damageEntries;

		public DamageReportMessage(String caseID) {
			if (caseID == null) 
				throw new IllegalArgumentException();
			
			this.setCaseID(caseID);
			this.damageEntries = new ArrayList<DamageEntry>();			
		}
		public DamageReportMessage(String caseID,List<DamageEntry> damageEntries) {
			if (caseID == null) 
				throw new IllegalArgumentException();
			
			this.setCaseID(caseID);
			this.damageEntries = damageEntries;			
		}
		
		public void addDamageEntry(DamageEntry damageEntry) {
			if (damageEntry == null) 
				throw new IllegalArgumentException();
			
			this.damageEntries.add(damageEntry);
		}
		
		public List<DamageEntry> getDamageEntries() {
			return this.damageEntries;
		}
		public void setCaseID(String caseID) {
			if (caseID == null) 
				throw new IllegalArgumentException();
			this.caseID = caseID;
		}
		public String getCaseID() {
			return caseID;
		}

	

}
