package ag.carnot.praesentation.web.jsf.beans.preasentationworkflow.createcoveragedecision;

import java.util.List;
import java.util.ArrayList;

import de.wwu.wfm.sc4.msg.insuranceclaim.CoverageDecisionMessage;
import de.wwu.wfm.sc4.msg.insuranceclaim.DamageReportMessage;
import de.wwu.wfm.sc4.msg.insuranceclaim.data.*;

public class CreateCoverageDecisionBean {
  public void complete(){
  }
  private DamageReportMessage damageReportMessage;
  private List<CoverageDecisionEntry> coverageDecisionEntries;
  public CreateCoverageDecisionBean(){
  }
  
  public void setDamageReportMessage( DamageReportMessage msg) {
	  this.damageReportMessage = msg;
	  coverageDecisionEntries=new ArrayList<CoverageDecisionEntry>(msg.getDamageEntries().size());
	  for (DamageEntry entry:msg.getDamageEntries()){
		  coverageDecisionEntries.add(new CoverageDecisionEntry(entry.getName(),entry.getCosts(),false));
	  }
  }
  
  public DamageReportMessage getDamageReportMessage() {
	  return damageReportMessage;
  }
  public List<CoverageDecisionEntry> getCoverageDecisionEntries(){
	  return this.coverageDecisionEntries;
  }
  public CoverageDecisionMessage getCoverageDecisionMessage(){
	  return new CoverageDecisionMessage(damageReportMessage.getCaseID(),coverageDecisionEntries);
  }
}
