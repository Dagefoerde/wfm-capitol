package de.wwu.wfm.sc4.capitol.insuranceclaim.apps;

import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import de.wwu.wfm.sc4.capitol.data.Incident;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;
import de.wwu.wfm.sc4.mail.Mail;
import de.wwu.wfm.sc4.mail.MailAccounts;

public class ReminderEmail {

	public void complete(List<Incident> incidents) throws AddressException,
			MessagingException {

		for (Incident incident : incidents) {
			// TODO send email
			String recipient = incident.getContract().getCustomer().getEMail();
			String subject = "Accident Report Reminder - Capitol for People Inc.";
			String text = "Dear Customer,/n"
					+ "this is the weekly reminder to please provide a report for the insurance claim concerning the "
					+ incident.getCar().getType()
					+ " with license plate "
					+ incident.getCar().getLicencePlate()
					+ "/n"
					+ "It is required to process your claim. You can provide the report via the customer service on the website of our partner BVIS Mobility Solutions Ltd./n/n"
					+ "Kind regards,/nCapitol for People Inc.";

			Mail.send(MailAccounts.CAPITOL, recipient, subject, text);

			// if success:
			incident.setLastReminder(new Date());
			ServiceInitializer.getProvider().getIncidentService().persist(
					incident);
		}
	}
}
