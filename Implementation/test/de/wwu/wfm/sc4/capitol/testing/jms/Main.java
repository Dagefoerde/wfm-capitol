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

import ContractData.Car;
import ContractData.ContractData;
import ContractData.Requirements;
import CustomerData.Customer;
import DTO.DataTransferObject;
import General.Address;

import java.util.*;

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
			createDTOForCreateContractFromCustomerRequirements(session, q); //Initialize Capitols process for the creation of the coverage decision.
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

	private static void createDTOForCreateContractFromCustomerRequirements(Session session, Queue q) throws JMSException, IOException {
		DataTransferObject dto = createTestDTO();
		MessageProducer producer = session.createProducer(q);
		ActiveMQObjectMessage message = new ActiveMQObjectMessage();
		message.setStringProperty("processID", "contracting_CapitolnewCustomerRequirements");
		message.setObject(dto);
		producer.send(message);
		
	}
	
	private static DataTransferObject createTestDTO(){

		DataTransferObject dto = new DataTransferObject();
		ArrayList<Car> cars = new ArrayList<Car>();
		float value = 89000;
		cars.add(new Car("SU:FF:1337", "Black", "Limousine", value));
		Requirements req = new Requirements("Open", 100.0,100.0,true,cars);
		
		dto.setContractData(new ContractData(1,req,null,null));
		dto.setCustomer(new Customer("sn00per", "sn00per@gmx.de", "Marvin", "Franke", "01709036540", 1337, 1337, new Address(21,"Hermann-Hesse-Stra�e", "48161")));
		return dto;
	}

}
