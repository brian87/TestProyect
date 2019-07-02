package com.trading;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String name;
	private int MAX_NO_DEPOTS = 50;
	private List<Depot> depots = new ArrayList<Depot>();
	private List<Product> products = new ArrayList<Product>();

	public Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addDepot(Depot depot) {
		depot.setCompany(this);
		depots.add(depot);
	}

	public List<Depot> getDepots() {
		return depots;
	}

	public void setDepots(List<Depot> depots) {
		this.depots = depots;
	}

	public int getMaxNroDepots() {
		return MAX_NO_DEPOTS;
	}

	public void addProduct(Product product) {
		product.setProducer(this);
		products.add(product);
	}

	public List<Product> getProducts() {
		return products;
	}
	
	

}
