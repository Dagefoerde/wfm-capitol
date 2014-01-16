package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import ClaimData.ClaimReport;
import DTO.DataTransferObject;
import de.wwu.wfm.sc4.capitol.data.Car;
import de.wwu.wfm.sc4.capitol.data.Contract;
import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.exception.ContractNotFoundException;
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

		if (dto.getClaimData().getDamageReport() == null) {
			throw new IllegalArgumentException("dto has no damage report set");
		}
	}

	public Incident complete() {
		// Retrieve our Contract by ClaimReport->Car(LicensePlate)->Contract
		ClaimReport cr = dto.getClaimData().getClaimReport();
		ContractData.Car actualCar = cr.getCar();
		String licensePlateFromCar = actualCar.getLicensePlate();
		
		//fetch car out of our DB by license plate
		Car ourCar = ServiceInitializer.p().getCarService().findByLicencePlate(licensePlateFromCar);
		Contract actualContract = ServiceInitializer.p().getContractService().findById(ourCar.getContract().getId());
		
		//if there is an actualContract -> create incident
		if(actualContract != null){
			de.wwu.wfm.sc4.capitol.data.Incident newIncident = new Incident();
			newIncident.setContract(actualContract);
			newIncident.setSharedIncidentID(dto.getClaimData().getiD());

			return newIncident;
		}
		//no incident created cause of missing contract (not found in our db)
		else{
			throw new ContractNotFoundException("Contract could not be found in our database");
		}
	}
}
