package de.wwu.wfm.sc4.capitol.service;

import de.wwu.wfm.sc4.capitol.data.ServiceStation;

public class ServiceStationService extends AbstractServiceClass<ServiceStation> {

	public ClaimData.ServiceStation convertToDTOServiceStation(
			ServiceStation serviceStation) {
		return new ClaimData.ServiceStation(serviceStation.getPhone(),
			ServiceInitializer.p().getAddressService().convertToDTOAddress(serviceStation.getAddress()));
	}

	public ServiceStation convertFromDTOServiceStation(
			ClaimData.ServiceStation serviceStation) {
		return new ServiceStation(serviceStation.getPhone(), ServiceInitializer
				.p().getAddressService().convertFromDTOAddress(
						serviceStation.getAddress()));
	}

}
