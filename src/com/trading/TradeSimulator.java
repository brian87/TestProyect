package com.trading;

import java.util.ArrayList;
import java.util.List;

public class TradeSimulator {

	private List<Company> companies = new ArrayList<Company>();

	public static void main(String[] args) {
		TradeSimulator tradeSimulator = new TradeSimulator();
		tradeSimulator.init();
		tradeSimulator.showData();
	}

	private void init() {
		// Companies
		Company companyA = new Company("Company-A");
		Company companyB = new Company("Company-B");
		companies.add(companyA);
		companies.add(companyB);

		// Products
		Product productA = new Product("Product-A");
		companyA.addProduct(productA);

		Product productB = new Product("Product-B");
		companyB.addProduct(productB);

		// Depots
		for (int i = 1; i <= companyA.getMaxNroDepots(); i++) {
			Depot depot = new Depot("Depot-" + i);
			// Stock for Depot
			depot.addStock(new Stock(productA,8,3.0,5.0));
			companyA.addDepot(depot);
		}

		for (int i = 1; i <= companyB.getMaxNroDepots(); i++) {
			companyB.addDepot(new Depot("Depot-" + i));
		}		
	
	}

	private void showData() {
		for (Company company : companies) {
			showCompany(company);
		}
	}

	private void showCompany(Company company) {
		System.out.println("COMPANY: " + company.getName());
		for (Product product : company.getProducts()) {
			showProduct(product);
		}
		for (Depot depot : company.getDepots()) {
			showDepot(depot);
		}

	}

	private void showProduct(Product product) {
		System.out.println("PRODUCT: " + product.getName());

	}

	private void showDepot(Depot depot) {
		System.out.println("DEPOT: " + depot.getName());
		for (Stock stock : depot.getStock()) {
			showStock(stock);
		}
	}

	private void showStock(Stock stock) {
		System.out.println(stock);
	}

}
