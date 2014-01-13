package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Contract;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class InitializeIncident {
	private final DataTransferObject dto;

	public InitializeIncident(DataTransferObject dto) {
		this.dto = dto;
		if (dto == null)
			throw new IllegalArgumentException("dto may not be null");

		// Debugging code
		System.out
				.println("Expected communication reason: claimHandling_CapitolDamageReport");
		System.out.print("Actual communication reason: ");
		if (dto.getCommunicationReason() == null) {
			System.out.println("null");
		} else {
			System.out.println(dto.getCommunicationReason());
		}

		// DTO content verification
		// expect: ClaimData {ID, DamageReport}
		if (dto.getClaimData() == null) {
			throw new IllegalArgumentException("dto has no claim data set");
		}
		// if (dto.getClaimData().getiD() == null) {
		// cannot be null, as it is int (not Integer).

		if (dto.getClaimData().getDamageReport() == null) {
			throw new IllegalArgumentException("dto has no damage report set");
		}
	}

	public Incident complete() {
		Contract contract = ServiceInitializer.p().getContractService()
				.findBySharedId(dto.getContractData().getContractId());
		// TODO do we actually get contract data?! probably not.
		// Maybe retrieve via ClaimData->ClaimReport->Car

		if (contract == null) {
			// contract not found,
			return null;
		}

		// create new incident with contract
		Incident incident = new Incident();
		incident.setContract(contract);
		incident.setSharedIncidentID(dto.getClaimData().getiD());
		// do not add claim data yet, as this is done in a later activity
		// explicitly.

		return incident;
	}
}
