package de.wwu.wfm.sc4.msg.insuranceclaim;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import de.wwu.wfm.sc4.msg.insuranceclaim.data.CoverageDecisionEntry;

	/**
	 * Sent from Cars&Co via BVIS to Capitol
	 * (Processing the vehicle / ) -> (Claim Handling / Damage Report Handling) -> (Insurance claim / Record Incident)
	 * Contents: Damage Report, Cost estimation, Case
	 * 
	 * 
	 * @author Tobias
	 */
	public class CoverageDecisionMessage implements Serializable {

		/**
		 * please increment on every change!!
		 */
		private static final long serialVersionUID = 1L;
		
		private String caseID;
		private List<CoverageDecisionEntry> coverageDecisionEntries;

		public CoverageDecisionMessage(String caseID) {
			if (caseID == null) 
				throw new IllegalArgumentException();
			
			this.setCaseID(caseID);
			this.coverageDecisionEntries = new ArrayList<CoverageDecisionEntry>();			
		}
		public CoverageDecisionMessage(String caseID,List<CoverageDecisionEntry> coverageDecisionEntries) {
			if (caseID == null) 
				throw new IllegalArgumentException();
			
			this.setCaseID(caseID);
			this.coverageDecisionEntries = coverageDecisionEntries;			
		}
		
		public void addDamageEntry(CoverageDecisionEntry coverageDecisionEntry) {
			if (coverageDecisionEntry == null) 
				throw new IllegalArgumentException();
			
			this.coverageDecisionEntries.add(coverageDecisionEntry);
		}
		
		public List<CoverageDecisionEntry> getDamageEntries() {
			return this.coverageDecisionEntries;
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
