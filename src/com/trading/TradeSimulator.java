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

		for (int i = 1; i <= companyA.getMaxNroDepots(); i++) {
			String nombre = "Depot-" + i;
			companyA.addDepot(new Depot(nombre));
		}

		for (int i = 1; i <= companyB.getMaxNroDepots(); i++) {
			String nombre = "Depot-" + i;
			companyB.addDepot(new Depot(nombre));
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
		System.out.println("  PRODUCT: " + product.getName());

	}

	private void showDepot(Depot depot) {
		System.out.println("  DEPOT: " + depot.getName());
		for (Stock stock : depot.getStock()) {
			showStock(stock);
		}
	}

	private void showStock(Stock stock) {
		System.out.println("    STOCK: " + stock.getProduct().getName());
		System.out.println("      Depot: " + stock.getDepot().getName());
	}

}
