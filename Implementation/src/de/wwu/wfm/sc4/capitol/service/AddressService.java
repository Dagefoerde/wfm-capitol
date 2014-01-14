package de.wwu.wfm.sc4.capitol.service;

import ClaimData.ClaimReport;
import de.wwu.wfm.sc4.capitol.data.Address;

public class AddressService extends AbstractServiceClass<Address> {

	public Address createFromClaimReport(ClaimReport c) {
		int streetNumber = c.getCrashAddress().getStreetNumber();
		String street = c.getCrashAddress().getStreet();
		String postalCode = c.getCrashAddress().getPostalCode();
		Address address = new Address(streetNumber, street, postalCode);
		ServiceInitializer.getProvider().getAddressService().persist(address);
		return address;
	}
}
