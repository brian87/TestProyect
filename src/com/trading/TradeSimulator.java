package com.trading;

import java.util.ArrayList;
import java.util.List;

public class TradeSimulator {

	private List<Company> companies = new ArrayList<Company>();
	private List<Depot> depots = new ArrayList<Depot>();

	public static void main(String[] args) {
		TradeSimulator tradeSimulator = new TradeSimulator();
		tradeSimulator.init();
		tradeSimulator.print();
	}

	private void init() {
		//Companies
		Company companyA = new Company("Company-A");
		Company companyB = new Company("Company-B");
		companies.add(companyA);
		companies.add(companyB);
		
		//Depots - Company A
		//companyA.addDepot(new Depot("Depot-1"));		
		//Depots - Company B
		//companyB.addDepot(new Depot("Depot-1"));
		
		
		for (int i = 0; i < companyA.getMAX_NO_DEPOTS();i++) {
			String nombre = "Depot-"+i;
			companyA.addDepot(new Depot(nombre));
		}
		

		for (int i = 0; i < companyB.getMAX_NO_DEPOTS();i++) {
			String nombre = "Depot-"+i;
			companyB.addDepot(new Depot(nombre));
		}
		//for (Depot depot : companyA.getMAX_NO_DEPOTS()) {
		//	CompanyA.addDepot(new Depot ("Depot-1"))    
		//}
		//for (Depot depot : companyB.getMAX_NO_DEPOTS()) {
		//	CompanyA.addDepot(new Depot ("Depot-2"))    
		//}
		
		//Products - Company A	
		
		
	}

	private void print() {
		for (Company company : companies) {
			System.out.println("COMPANY: " + company.getName());
			printDepots(company);
		}

	}

	private void printDepots(Company company) {
		for (Depot depot : company.getDepots()) {
			System.out.println("DEPOT: " + depot.getName());			
		}
	}

}
