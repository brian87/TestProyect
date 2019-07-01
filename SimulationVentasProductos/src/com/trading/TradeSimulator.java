package com.trading;

import java.util.ArrayList;
import java.util.List;

public class TradeSimulator {

	private List<Company> companies = new ArrayList<Company>();

	public static void main(String[] args) {
		TradeSimulator tradeSimulator = new TradeSimulator();
		tradeSimulator.init();
		tradeSimulator.print();
	}

	private void init() {
		initCompanies();
	}

	private void initCompanies() {
		Company companyA = new Company("Company-A");
		Company companyB = new Company("Company-B");
		companies.add(companyA);
		companies.add(companyB);
	}

	private void print() {
		for(Company company:companies) {
			System.out.println(company.getName());
		}

	}

}
