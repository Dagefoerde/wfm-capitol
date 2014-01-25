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

import de.wwu.wfm.sc4.capitol.data.Case;

import ClaimData.ClaimData;
import ClaimData.ClaimReport;
import ClaimData.DamageReport;
import ClaimData.Entry;
import ClaimData.Invoice;
import ClaimData.InvoiceElement;
import ClaimData.ServiceStation;
import ContractData.Car;
import ContractData.ContractData;
import ContractData.Requirements;
import CustomerData.Customer;
import DTO.DataTransferObject;
import General.Address;

import java.util.*;

public class Main {

	public static enum Methods{
		consume,
		createDTOForCreateContractFromCustomerRequirements,
		createDTOForDamageReports,
		createDTOForAccidentReports,
		createDTOForInvoices,
		produceDR,
		createDTOForAccaptanceOfContract,
		createDTOForTerminationOfContract;
	}
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
			Methods method=Methods.valueOf(args[0]);
			if (method!=null){
				switch (method){
				case consume: consume(session, q); break;
				case createDTOForCreateContractFromCustomerRequirements: createDTOForCreateContractFromCustomerRequirements(session, q); break;//Initialize Capitols process for the creation of the coverage decision.
				case createDTOForDamageReports:createDTOForDamageReports(session, q); break;//Initialize Capitols process for claim processing
				case createDTOForAccidentReports:createDTOForAccidentReports(session, q); break;//Initialize Capitols process for claim processing
				case createDTOForAccaptanceOfContract:	createDTOForAccaptanceOfContract(session,q); break;
				case createDTOForInvoices: createDTOForInvoices(session, q); break;//Initialize Capitols process for claim processing
				//case produceDR: produceDR(session, q); break;//Initialize first Cars&Co process
				case createDTOForTerminationOfContract: createDTOForTerminationOfContract(session,q); break;
				}
					
			}

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
		DataTransferObject dto = createCreateContractDTO();
		MessageProducer producer = session.createProducer(q);
		ActiveMQObjectMessage message = new ActiveMQObjectMessage();
		message.setStringProperty("processID", "CO_B_NewCR");
		message.setObject(dto);
		producer.send(message);
		
	}
	private static void createDTOForTerminationOfContract(Session session,
			Queue q) throws JMSException, IOException {
		DataTransferObject dto = new DataTransferObject();
		dto.setContractData(new ContractData());
		dto.getContractData().setContractId(13);
		MessageProducer producer = session.createProducer(q);
		ActiveMQObjectMessage message = new ActiveMQObjectMessage();
		message.setStringProperty("processID", "CO_B_Term");
		message.setObject(dto);
		producer.send(message);
		
	}

	private static void createDTOForAccaptanceOfContract(Session session,
			Queue q) throws JMSException, IOException {
		DataTransferObject dto = new DataTransferObject();
		dto.setContractData(new ContractData());
		dto.getContractData().setContractId(13);		
		MessageProducer producer = session.createProducer(q);
		ActiveMQObjectMessage message = new ActiveMQObjectMessage();
		message.setStringProperty("processID", "CO_B_Acc");
		message.setObject(dto);
		producer.send(message);
		
	}
	private static void createDTOForDamageReports(Session session, Queue q) throws JMSException, IOException {
		DataTransferObject dto = createDamageReportDTO();
		MessageProducer producer = session.createProducer(q);
		ActiveMQObjectMessage message = new ActiveMQObjectMessage();
		message.setStringProperty("processID", "CL1_B_Init");
		message.setObject(dto);
		producer.send(message);
		
	}
	private static void createDTOForAccidentReports(Session session, Queue q) throws JMSException, IOException {
		DataTransferObject dto = createAccidentReportDTO();
		MessageProducer producer = session.createProducer(q);
		ActiveMQObjectMessage message = new ActiveMQObjectMessage();
		message.setStringProperty("processID", "CL1_B_DmRep");
		message.setObject(dto);
		producer.send(message);
		
	}
	
	private static void createDTOForInvoices(Session session, Queue q) throws JMSException, IOException {
		DataTransferObject dto = createInvoiceDTO();
		MessageProducer producer = session.createProducer(q);
		ActiveMQObjectMessage message = new ActiveMQObjectMessage();
		message.setStringProperty("processID", "CL4_CC_Invoi");
		message.setObject(dto);
		producer.send(message);
		
	}
	
	private static DataTransferObject createCreateContractDTO(){

		DataTransferObject dto = new DataTransferObject();
		ArrayList<Car> cars = new ArrayList<Car>();
		float value = 89000;
		cars.add(new Car("SU:FF:1337", "Black", "Limousine", value));
		cars.add(new Car("XX:YY:42", "Black", "Batmobil", 900000));
		Requirements req = new Requirements("Open", 100.0,100.0,true,cars);
		Date time = Calendar.getInstance().getTime();
		req.setStartDate(Calendar.getInstance().getTime());
		time.setYear(2016);
		req.setEndDate(time);
		dto.setContractData(new ContractData(13,req,null,null));
		dto.setCustomer(new Customer("sn00per", "sn00per@gmx.de", "Marvin", "Franke", "01709036540", 1337, 1337, new Address(21,"Hermann-Hesse-Straße", "48161", "Münster")));
		return dto;
	}
	
	private static DataTransferObject createDamageReportDTO(){

		DataTransferObject dto = new DataTransferObject();
		dto.setCommunicationReason("claimHandling_CapitolDamageReport");
		ClaimReport claimReport = new ClaimReport(null, null, null, new Car("XX:YY:42","green","PKW",999), null, null, false, false);
		
		ArrayList<Entry> damages = new ArrayList<Entry>();
		damages.add(new Entry(1, "Broken Window", 1000));
		damages.add(new Entry(2, "Gas pedal", 70));
		damages.add(new Entry(1, "Heater", 2500));
		
		DamageReport damageReport = new DamageReport(damages, "Hans Wurst", new ServiceStation("0800/29923",new Address(9,"Kartoffelweg","29223","Celle")));
		ClaimData claimData = new ClaimData(123, claimReport, null, damageReport, null, null, null);
		
		dto.setClaimData(claimData);
		dto.setContractData(new ContractData(13, null, null, null));
		
		return dto;
	}
	
	private static DataTransferObject createAccidentReportDTO(){

		DataTransferObject dto = new DataTransferObject();
		dto.setCommunicationReason("claimHandling_CapitolAccidentReport");
		
		Address addr = new Address(12, "Poitzen", "D-29328", "Faßberg");
		
		Customer customer = new Customer();
		customer.setUsername("abcd");
		
		Car car = new Car();
		car.setLicensePlate("XX:YY:42");
		
		ClaimReport claimReport = new ClaimReport(addr, Calendar.getInstance().getTime()
				, customer, car, "cause", "description", false, true);
		
		ArrayList<Entry> damages = new ArrayList<Entry>();
		damages.add(new Entry(1, "Broken Window", 1000));
		damages.add(new Entry(2, "Gas pedal", 70));
		damages.add(new Entry(1, "Heater", 2500));
		
		DamageReport damageReport = new DamageReport(damages, "Hans Wurst", new ServiceStation("0800/29923",new Address(9,"Kartoffelweg","29223","Celle")));
		
		
		ClaimData claimData = new ClaimData(123, claimReport, null, damageReport, null, null, null);
		
		dto.setClaimData(claimData);
		
		return dto;
	}
	
	private static DataTransferObject createInvoiceDTO(){

		DataTransferObject dto = new DataTransferObject();
		dto.setCommunicationReason("claimHandling_CapitolReceiveInvoice");
		
		Invoice invoice = new Invoice(null);
		invoice.setDate(new Date());
		invoice.setPointOfContact("Pointi");
		invoice.setDueSum(3500);
		invoice.setInvoiceNumber(122);
		invoice.setInvoiceText("Helloooo");
		invoice.setPaymentTerm(new Date());
		invoice.setBankAccount("123456789");
		invoice.setBankCode("25750001");
		invoice.setBankAccountHolder("C&C");
		invoice.setBankName("Spk Ms Ost");
		
		List<InvoiceElement> list = new ArrayList<InvoiceElement>();
		
		InvoiceElement inv1 = new InvoiceElement();
		inv1.setAmount(1000);
		inv1.setDescription("Broken Window");
		list.add(inv1);
		InvoiceElement inv3 = new InvoiceElement();
		inv3.setAmount(2500);
		inv3.setDescription("Heater");
		list.add(inv3);
		
		invoice.setInvoiceElements(list);
		
		ClaimData claimData = new ClaimData(123, null, null, null, null, invoice, null);
		
		dto.setClaimData(claimData);
		
		return dto;
	}

}
