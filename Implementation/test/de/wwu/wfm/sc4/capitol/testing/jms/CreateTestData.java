package de.wwu.wfm.sc4.capitol.testing.jms;

import java.util.ArrayList;
import java.util.List;

import de.wwu.wfm.sc4.capitol.data.*;
import de.wwu.wfm.sc4.capitol.data.Case.NegotiationState;
import de.wwu.wfm.sc4.capitol.service.ServiceInitializer;

public class CreateTestData {
	
	public static void main(String[] args){
		Case case1 = new Case();
		List contractList1 = new ArrayList<Contract>();
		Case case2 = new Case();
		List contractList2 = new ArrayList<Contract>();
		Case case3 = new Case();
		List contractList3 = new ArrayList<Contract>();
		
		Customer customer1 = new Customer("Peter", "Fastert", "destroyer88","0172/5029384");
		customer1.setEMail("destroyer88@hotmail.de");
		Customer customer2 = new Customer("Willi", "Affenvater", "Affi59","04442/502938");
		customer2.setEMail("dr.affenvater@aol.com");
		Customer customer3 = new Customer("Räudiger", "Hartmann", "hartmann","05141/502999");
		customer3.setEMail("der-harte@gmx.de");
		
		Car car1 = new Car("CE-JM 999","PKW","green",999.99);
		Car car2 = new Car("MS-XX 979","PKW","blue",313.99);
		Car car3 = new Car("H-ELP 79","PKW","pink",19387.99);
		
		Contract contract1 = new Contract();
		List carList1 = new ArrayList<Car>();
		carList1.add(car1);
		contract1.setCars(carList1);
		car1.setContract(contract1);
		contract1.setCustomer(customer1);
		contract1.setSharedContractId(1);
		contract1.setCase0(case1);
		contract1.setNaturalInsured(500.10);
		contract1.setHumanInsured(3000.99);
		contract1.setPickupService(true);
		contractList1.add(contract1);
		
		Contract contract3 = new Contract();
		List carList3 = new ArrayList<Car>();
		carList3.add(car3);
		contract3.setCars(carList3);
		car3.setContract(contract3);
		contract3.setCustomer(customer3);
		contract3.setSharedContractId(2);
		contract3.setCase0(case3);
		contract3.setNaturalInsured(700.10);
		contract3.setHumanInsured(100.99);
		contract3.setPickupService(false);
		contractList3.add(contract3);
		
		
		case1.setContract(contractList1);
		case1.setCustomer(customer1);
		case1.setNegotiationState(NegotiationState.Accepted);
		
		case2.setCustomer(customer2);
		case2.setNegotiationState(NegotiationState.inNegotiation);

		case3.setContract(contractList3);
		case3.setNegotiationState(NegotiationState.inNegotiation);

		
		
		//persist
		ServiceInitializer.getProvider().getCaseService().persist(case1); //should cascade to all
		ServiceInitializer.getProvider().getCaseService().persist(case2); //should cascade to all
		ServiceInitializer.getProvider().getCaseService().persist(case3); //should cascade to all
	}

}
