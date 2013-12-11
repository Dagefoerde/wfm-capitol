package ag.carnot.praesentation;

import java.util.ArrayList;

import de.wwu.wfm.sc4.msg.insuranceclaim.DamageReportMessage;
import de.wwu.wfm.sc4.msg.insuranceclaim.data.DamageEntry;

public class dummy {
	
	public void setDR(DamageReportMessage d) {
		System.out.println(d);
		System.out.println(d.getCaseID());
		System.out.println(d.getDamageEntries());
		System.out.println(d.getDamageEntries().get(0));
	}
}
