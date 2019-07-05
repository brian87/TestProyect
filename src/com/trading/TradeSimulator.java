package com.trading;
//Java 1.8

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class TradeSimulator {

	private Integer MIN_NATIVE_PRODUCT_QUANTITY = 15;
	private Integer MAX_NATIVE_PRODUCT_QUANTITY = 50;
	private Integer MIN_EXTERNAL_PRODUCT_QUANTITY = 15;
	private Integer MAX_EXTERNAL_PRODUCT_QUANTITY = 50;
	private Double MIN_ALLOWANCE_FOR_DEPOT = 50.00;
	private Double MAX_ALLOWANCE_FOR_DEPOT = 100.00;
	private Double MIN_PRODUCT_PRICE = 1.00;
	private Double MAX_PRODUCT_PRICE = 10.00;

	private List<Company> companies = new ArrayList<Company>();

	public static void main(String[] args) {
		TradeSimulator tradeSimulator = new TradeSimulator();
		tradeSimulator.init();
		tradeSimulator.show();
		tradeSimulator.simulateTransactions();
	}

	private void init() {
		// Random

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
			Double allowance = getRandomDouble(MIN_ALLOWANCE_FOR_DEPOT, MAX_ALLOWANCE_FOR_DEPOT);
			Depot depot = new Depot(companyA, "Depot-" + i, allowance);
			// Stock for Depot
			Integer quantity = getRandomInteger(MIN_NATIVE_PRODUCT_QUANTITY, MAX_NATIVE_PRODUCT_QUANTITY);
			Double productPrice = getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			Double deliveryPrice = getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			depot.addStock(new Stock(productA, Type.NATIVE, quantity, productPrice, deliveryPrice));
			companyA.addDepot(depot);
		}

		for (int i = 1; i <= companyB.getMaxNroDepots(); i++) {
			Double allowance = getRandomDouble(MIN_ALLOWANCE_FOR_DEPOT, MAX_ALLOWANCE_FOR_DEPOT);
			Depot depot = new Depot(companyB, "Depot-" + i, allowance);
			// Stock for Depot
			Integer quantity = getRandomInteger(MIN_NATIVE_PRODUCT_QUANTITY, MAX_NATIVE_PRODUCT_QUANTITY);
			Double productPrice = getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			Double deliveryPrice = getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			depot.addStock(new Stock(productB, Type.NATIVE, quantity, productPrice, deliveryPrice));
			companyB.addDepot(depot);
		}
		
		pressAnyKeyToContinue();    
		
	}

	private void simulateTransactions() {
		Transaccion transaccion = new Transaccion();
		List<Integer> pairRandomIntegers = getPairRandomIntegers(2);
		Company buyerCompany = companies.get(pairRandomIntegers.get(0));
		Company sellerCompany = companies.get(pairRandomIntegers.get(1));
		Depot buyerDepot = buyerCompany.getDepots().get(getRandomInteger(buyerCompany.getDepots().size()));
		Depot sellerDepot = sellerCompany.getDepots().get(getRandomInteger(sellerCompany.getDepots().size()));
		transaccion.setBuyerDepot(buyerDepot);
		transaccion.setSellerDepot(sellerDepot);
		System.out.println("Buyer " + buyerCompany + " " + transaccion.getBuyerDepot());
		System.out.println("Seller " + sellerCompany + " " + transaccion.getSellerDepot());

	}	

	private Double getRandomDouble(Double max) {
		return getRandomDouble(0.0, max);
	}

	private Double getRandomDouble(Double min, Double max) {
		Random random = new Random();
		return min + (max - min) * random.nextDouble();
	}

	private Integer getRandomInteger(Integer max) {
		return getRandomInteger(0, max);
	}

	private Integer getRandomInteger(Integer min, Integer max) {
		Random random = new Random();
		return min + random.nextInt(max - min);
	}
	
	public List<Integer> getPairRandomIntegers(Integer max) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < max; i++) {
			list.add(i);
		}
		Collections.shuffle(list);
		return list;
	}

	private void show() {
		for (Company company : companies) {
			showCompany(company);
		}
	}

	private void showCompany(Company company) {
		System.out.println(company);
		for (Product product : company.getProducts()) {
			showProduct(product);
		}
		for (Depot depot : company.getDepots()) {
			showDepot(depot);
		}

	}

	private void showProduct(Product product) {
		System.out.println(product);

	}

	private void showDepot(Depot depot) {
		System.out.println(depot);
		for (Stock stock : depot.getStock()) {
			showStock(stock);
		}
	}

	private void showStock(Stock stock) {
		System.out.println(stock);
	}
	
	public void addStock(Product product, Type type, Integer quantity) {
		
	}
	
	private void pressAnyKeyToContinue() {
		System.out.println("Press Enter key to continue..."); 
		try {
			System.in.read();
			} 
		catch(Exception e) {
			
		} 
	}

}
