package ag.carnot.praesentation.web.jsf.beans.preasentationworkflow.createcoveragedecision;

import java.util.List;
import java.util.ArrayList;
import de.wwu.wfm.sc4.msg.insuranceclaim.data.*;

public class CreateCoverageDecisionBean {
  public void complete(){
  }
  private String caseID;
  private ArrayList<CoverageDecisionEntry> coverageDecisions;
  
  
  public String getCaseID(){
    return caseID;
  }
  public void setCaseID(  String caseID){
    this.caseID=caseID;
  }
  
  public void setDamageEntries( List<DamageEntry> entries) {
	  coverageDecisions = new ArrayList<CoverageDecisionEntry>();
	  /*
	  for (DamageEntry entry : entries) {
		coverageDecisions.add(new CoverageDecisionEntry(entry.getName(), entry.getCosts(), false));  
	  }
	  */
  }
  
  public List<CoverageDecisionEntry> getCoverageDecisions() {
	  return coverageDecisions;
  }
}
