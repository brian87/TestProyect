package com.trading;

import java.util.ArrayList;
import java.util.List;

public class Depot {
	private String name;
	private Company company;
	private List<Stock> stock = new ArrayList<Stock>();

	public Depot(String name) {
		this.name=name;
	}

	public void addProduct(Product product) {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public List<Stock> getStock() {
		return stock;
	}

	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}
	
	

}
