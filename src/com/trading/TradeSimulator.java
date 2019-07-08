package com.trading;
//Java 1.8

import java.util.ArrayList;
import java.util.List;

public class TradeSimulator {

	private Integer MIN_NATIVE_PRODUCT_QUANTITY = 15;
	private Integer MAX_NATIVE_PRODUCT_QUANTITY = 50;
	private Integer MIN_EXTERNAL_PRODUCT_QUANTITY = 3;
	private Integer MAX_EXTERNAL_PRODUCT_QUANTITY = 40;
	private Double MIN_ALLOWANCE_FOR_DEPOT = 50.00;
	private Double MAX_ALLOWANCE_FOR_DEPOT = 100.00;
	private Double MIN_PRODUCT_PRICE = 1.00;
	private Double MAX_PRODUCT_PRICE = 10.00;

	private List<Company> companies = new ArrayList<Company>();
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public static void main(String[] args) {
		TradeSimulator tradeSimulator = new TradeSimulator();

		waitForKeyPress("1. Initialize data.");
		tradeSimulator.initData();

		waitForKeyPress("2. Show generated data.");
		tradeSimulator.showData();

		waitForKeyPress("3. Simulate transactions.");
		tradeSimulator.simulateTransactions();

		waitForKeyPress("4. Show transactions.");
		tradeSimulator.showTransactions();
	}

	private void initData() {

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

		// Depots for CompanyA
		for (int i = 1; i <= companyA.getMaxNroDepots(); i++) {
			Double allowance = RandomUtil.getRandomDouble(MIN_ALLOWANCE_FOR_DEPOT, MAX_ALLOWANCE_FOR_DEPOT);
			Depot depot = new Depot(companyA, "Depot-" + i, allowance);
			
			// Initial Stock for NATIVE product
			Integer quantity = RandomUtil.getRandomInteger(MIN_NATIVE_PRODUCT_QUANTITY, MAX_NATIVE_PRODUCT_QUANTITY);
			Double productPrice = RandomUtil.getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			Double deliveryPrice = RandomUtil.getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			depot.addStock(new Stock(productA, Type.NATIVE, quantity, productPrice, deliveryPrice));
			
			// Initial Stock for EXTERNAL product
			quantity = RandomUtil.getRandomInteger(MIN_EXTERNAL_PRODUCT_QUANTITY, MAX_EXTERNAL_PRODUCT_QUANTITY);
			productPrice = RandomUtil.getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			deliveryPrice = RandomUtil.getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			depot.addStock(new Stock(productB, Type.EXTERNAL, quantity, productPrice, deliveryPrice));
			
			depot.setCompany(companyA);
			companyA.addDepot(depot);
		}

		// Depots for CompanyB
		for (int i = 1; i <= companyB.getMaxNroDepots(); i++) {
			Double allowance = RandomUtil.getRandomDouble(MIN_ALLOWANCE_FOR_DEPOT, MAX_ALLOWANCE_FOR_DEPOT);
			Depot depot = new Depot(companyB, "Depot-" + i, allowance);
			
			// Initial Stock for NATIVE product
			Integer quantity = RandomUtil.getRandomInteger(MIN_NATIVE_PRODUCT_QUANTITY, MAX_NATIVE_PRODUCT_QUANTITY);
			Double productPrice = RandomUtil.getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			Double deliveryPrice = RandomUtil.getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			depot.addStock(new Stock(productB, Type.NATIVE, quantity, productPrice, deliveryPrice));
			
			// Initial Stock for EXTERNAL product
			quantity = RandomUtil.getRandomInteger(MIN_EXTERNAL_PRODUCT_QUANTITY, MAX_EXTERNAL_PRODUCT_QUANTITY);
			productPrice = RandomUtil.getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			deliveryPrice = RandomUtil.getRandomDouble(MIN_PRODUCT_PRICE, MAX_PRODUCT_PRICE);
			depot.addStock(new Stock(productA, Type.EXTERNAL, quantity, productPrice, deliveryPrice));
			
			depot.setCompany(companyB);
			companyB.addDepot(depot);
		}

	}

	private void simulateTransactions() {
		for (int i = 0; i <= 100; i++) {
			//Generate Random Transaction until it's is valid to process
			Transaction transaction=null;
			for (int j=0; j <= 10; j++) {
				transaction = getRandomTransaction();
				if(!isValidTransaction(transaction)) {
					break;
				}
			}
			processTransaction(transaction);
			transactions.add(transaction);
		}

	}

	private boolean isValidTransaction(Transaction transaction) {
		// Quantity == 0 is invalid. 
		if(transaction.getQuantity()==0) {
			return false;	
		}
		return true;
	}

	private void processTransaction(Transaction transaction) {
		Depot buyerDepot = transaction.getBuyerDepot();
		Depot sellerDepot = transaction.getSellerDepot();
		buyerDepot.increaseStock(buyerDepot.getStock(transaction.getProduct()), transaction.getQuantity());
		sellerDepot.decreaseStock(sellerDepot.getStock(transaction.getProduct()), transaction.getQuantity());
		buyerDepot.decreaseAlowance(transaction.getTotal());
		sellerDepot.increaseAlowance(transaction.getTotal());
		
	}

	private Transaction getRandomTransaction() {
		List<Integer> pairRandomIntegers = RandomUtil.getPairRandomIntegers(2);
		Company buyerCompany = companies.get(pairRandomIntegers.get(0));
		Company sellerCompany = companies.get(pairRandomIntegers.get(1));
		Depot buyerDepot = buyerCompany.getDepots().get(RandomUtil.getRandomInteger(buyerCompany.getDepots().size()));
		Depot sellerDepot = sellerCompany.getDepots()
				.get(RandomUtil.getRandomInteger(sellerCompany.getDepots().size()));
		Product product = sellerCompany.getProducts().get(0); // There's only one product
		Stock sellerStock = sellerDepot.getStock(product);// TODO This stock should be Internal always.
		Stock buyerStock = buyerDepot.getStock(product); // TODO This stock should be External always.

		Integer quantity = getRandomQuantity(sellerDepot, buyerDepot, product);
		Double total = (sellerStock.getDeliveryPrice() + sellerStock.getProductPrice()) * quantity;
		
		Transaction transaction = new Transaction();
		transaction.setBuyerDepot(buyerDepot);
		transaction.setSellerDepot(sellerDepot);
		transaction.setProduct(product);
		transaction.setQuantity(quantity);
		transaction.setTotal(total);
		
		return transaction;
	}

	private Integer getRandomQuantity(Depot sellerDepot, Depot buyerDepot, Product product) {
		// Calc limits for Quantity allowed
		Stock sellerStock = sellerDepot.getStock(product);// TODO This stock should be Internal always.
		Stock buyerStock = buyerDepot.getStock(product); // TODO This stock should be External always.
		Integer maxQuantityBuying = MAX_EXTERNAL_PRODUCT_QUANTITY - buyerStock.getQuantity();
		Integer maxQuantitySelling = sellerStock.getQuantity() - MIN_NATIVE_PRODUCT_QUANTITY;
		Integer maxAlloweQuantity = Math.min(maxQuantityBuying, maxQuantitySelling);
		//TODO  quantities cannot be negative before this line.
		if(maxAlloweQuantity== 0) {
			return 0;
		}else {
			return RandomUtil.getRandomInteger(1, maxAlloweQuantity);
		}	
		
	}

	private void showData() {
		Logger.showCompanies(companies);
	}

	private void showTransactions() {
		Logger.showTransactions(transactions);

	}

	private static void waitForKeyPress(String msg) {
		System.out.print(msg + " Press ENTER key to continue...");
		try {
			System.in.read();
		} catch (Exception e) {

		}
	}

}
