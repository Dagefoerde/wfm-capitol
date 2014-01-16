package de.wwu.wfm.sc4.capitol.service;

import ClaimData.Entry;
import de.wwu.wfm.sc4.capitol.data.DamageReportEntry;

public class DamageReportEntryService extends
		AbstractServiceClass<DamageReportEntry> {

	public Entry convertToDTOEntry(DamageReportEntry dre) {
		return new Entry(dre.getPosition(), dre.getDescription(), dre
				.getCostEstimation(), dre.getCoverageDecision());
	}

}
