package de.wwu.wfm.sc4.capitol.service;

import ClaimData.ClaimReport;
import de.wwu.wfm.sc4.capitol.data.Address;

public class AddressService extends AbstractServiceClass<Address> {

	public Address createFromClaimReport(ClaimReport c) {
		int streetNumber = c.getCrashAddress().getStreetNumber();
		String street = c.getCrashAddress().getStreet();
		String postalCode = c.getCrashAddress().getPostalCode();
		String city = c.getCrashAddress().getCity();
		Address address = new Address(streetNumber, street, postalCode, city);
		ServiceInitializer.getProvider().getAddressService().persist(address);
		return address;
	}

	public General.Address convertToDTOAddress(Address address) {
		return new General.Address(address.getStreetNumber(), address
				.getStreet(), address.getPostalCode(), address.getCity());
	}

	public Address convertFromDTOAddress(General.Address address) {
		return new Address(address.getStreetNumber(), address.getStreet(),
				address.getPostalCode(), address.getCity());
	}
}
