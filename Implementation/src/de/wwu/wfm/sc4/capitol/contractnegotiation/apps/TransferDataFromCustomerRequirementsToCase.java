package de.wwu.wfm.sc4.capitol.contractnegotiation.apps;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Case;

public class TransferDataFromCustomerRequirementsToCase {

	private DataTransferObject dto;
	private Case case0;

	public TransferDataFromCustomerRequirementsToCase() {

	}

	public void setCustomerRequirements(DataTransferObject dto) {

		this.dto = dto;

	}

	public Case getCase() {
		return case0;
	}

	public void complete() {
		case0=new Case(dto.getContractData().getContractId());
	}

}
