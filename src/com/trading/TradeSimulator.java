package com.trading;

import java.util.ArrayList;
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
			Double allowance = generateRandomDouble(MIN_ALLOWANCE_FOR_DEPOT, MAX_ALLOWANCE_FOR_DEPOT);
			Depot depot = new Depot(companyA, "Depot-" + i, allowance);
			// Stock for Depot			
			Integer quantity = generateRandomInteger(MIN_NATIVE_PRODUCT_QUANTITY, MAX_NATIVE_PRODUCT_QUANTITY);
			Double productPrice = generateRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			Double deliveryPrice = generateRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			depot.addStock(new Stock(productA, Stock.Type.NATIVE, quantity, productPrice, deliveryPrice));
			companyA.addDepot(depot);
		}

		for (int i = 1; i <= companyB.getMaxNroDepots(); i++) {
			Double allowance = generateRandomDouble(MIN_ALLOWANCE_FOR_DEPOT, MAX_ALLOWANCE_FOR_DEPOT);
			Depot depot = new Depot(companyB, "Depot-" + i, allowance);
			// Stock for Depot			
			Integer quantity = generateRandomInteger(MIN_NATIVE_PRODUCT_QUANTITY, MAX_NATIVE_PRODUCT_QUANTITY);
			Double productPrice = generateRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			Double deliveryPrice = generateRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			depot.addStock(new Stock(productB, Stock.Type.NATIVE, quantity, productPrice, deliveryPrice));
			companyB.addDepot(depot);
		}
		
		//transaccion
		Transaccion transaccion = new Transaccion();
		transaccion.setSellerDepot(productA.getProducer().getDepots().get(0));
		System.out.println("Seller " + transaccion.getSellerDepot().getCompany().getName()+ " "+
							transaccion.getSellerDepot().getName());
		
		transaccion.setBuyerDepot(productB.getProducer().getDepots().get(0));
		System.out.println("Buyer " + transaccion.getBuyerDepot().getCompany().getName()+ " "+
				transaccion.getSellerDepot().getName());
	}

	private Double generateRandomDouble(Double min, Double max) {
		Random random = new Random();
		return min + (max - min) * random.nextDouble();
	}

	private Integer generateRandomInteger(Integer min, Integer max) {
		Random random = new Random();
		return min + random.nextInt(max - min);
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

}
