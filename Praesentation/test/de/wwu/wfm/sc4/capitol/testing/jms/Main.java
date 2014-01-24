package de.wwu.wfm.sc4.capitol.testing.jms;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.command.ActiveMQTextMessage;

import de.wwu.wfm.sc4.msg.insuranceclaim.DamageReportMessage;
import de.wwu.wfm.sc4.msg.insuranceclaim.data.DamageEntry;

public class Main {

	/**
	 * @param args
	 * @throws JMSException
	 */
	public static void main(String[] args) throws JMSException {

		ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory();
		//cf.setBrokerURL("tcp://wi-vm028.uni-muenster.de:61617");
		cf.setBrokerURL("tcp://localhost:61616");
		Connection con = null;

		try {
			con = cf.createConnection();
			System.out.println(con);
			Session session = con
					.createSession(false, Session.AUTO_ACKNOWLEDGE);
			con.start();
			System.out.println(con);
			System.out.println(session);
			Queue q = session.createQueue("CarnotApplicationQueue");
			System.out.println(session);
			System.out.println(q);
			//consume(session, q);
			produceCreateCoverageDecision(session, q); //Initialize Capitols process for the creation of the coverage decision.
			//produceDR(session, q); //Initialize first Cars&Co process
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}

	}

	private static void consume(Session session, Queue q) throws JMSException {

		MessageConsumer consumer = session.createConsumer(q);
		while (true) {
			Message message = consumer.receive(10000);
			if (message != null) {
				ActiveMQTextMessage textMsg = (ActiveMQTextMessage) message;
				System.out.println("Neue Nachricht: ");
				System.out.println(textMsg);
				System.out.println(textMsg.getText());
				
			}
		}
	}

	private static void produceCreateCoverageDecision(Session session, Queue q) throws JMSException, IOException {
		DamageReportMessage drm = new DamageReportMessage("ManuallySend");
		drm.addDamageEntry(new DamageEntry("Engine", 2500.0));
		drm.addDamageEntry(new DamageEntry("Window", 500.0));
		drm.addDamageEntry(new DamageEntry("Wheels", 500.0));
		drm.addDamageEntry(new DamageEntry("Door", 1000.0));
		MessageProducer producer = session.createProducer(q);
		ActiveMQObjectMessage message = new ActiveMQObjectMessage();
		message.setStringProperty("processID", "CreateCoverageDecision");
		message.setObject(drm);
		producer.send(message);
		
	}
	private static void produceDR(Session session, Queue q) throws JMSException, IOException {
		DamageReportMessage drm = new DamageReportMessage("ManuallySend");
		drm.addDamageEntry(new DamageEntry("Engine", 2000.0));
		drm.addDamageEntry(new DamageEntry("Window", 360.0));
		drm.addDamageEntry(new DamageEntry("Wheels", 166.0));
		drm.addDamageEntry(new DamageEntry("Door", 437.0));
		MessageProducer producer = session.createProducer(q);
		ActiveMQObjectMessage message = new ActiveMQObjectMessage();
		message.setStringProperty("processID", "CuC_DamageReport");
		message.setObject(new String("ManuallySend"));
		producer.send(message);
		
	}
	
	

}
