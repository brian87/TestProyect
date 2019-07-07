package com.trading;

import java.util.List;

public class Logger {

	public static void showCompanies(List<Company> companies) {
		for (Company company : companies) {
			showCompany(company);
		}
	}

	public static void showCompany(Company company) {
		System.out.println(company);
		for (Product product : company.getProducts()) {
			showProduct(product);
		}
		for (Depot depot : company.getDepots()) {
			showDepot(depot);
		}

	}

	public static void showProduct(Product product) {
		System.out.println(product);

	}

	public static void showDepot(Depot depot) {
		System.out.println(depot);
		for (Stock stock : depot.getStock()) {
			showStock(stock);
		}
	}

	public static void showStock(Stock stock) {
		System.out.println(stock);
	}

	public static void showTransactions(List<Transaction> transactions) {
		for (Transaction transaction : transactions) {
			showTransaction(transaction);
		}
	}

	public static void showTransaction(Transaction transaction) {
		System.out.println(transaction);
	}

}
