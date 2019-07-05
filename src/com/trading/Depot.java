package com.trading;

import java.util.ArrayList;
import java.util.List;

public class Depot {
	private Double allowance;
	private String name;
	private Company company;
	private List<Stock> stocks = new ArrayList<Stock>();

	public Double getAllowance() {
		return allowance;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public Depot(Company company, String name, Double allowance) {
		this.company = company;
		this.name = name;
		this.allowance = allowance;
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
		return stocks;
	}

	public void setStock(List<Stock> stock) {
		this.stocks = stock;
	}

	public void addStock(Stock stock) {
		stock.setDepot(this);
		stocks.add(stock);
	}
	
	public void removeStock(Product product, Integer quantity) {
		
	}

	public String toString() {
		return "DEPOT: " + getName()+"\t \t"+
	           "INITIAL CASH:"+String.format("%.2f", allowance);
				

	}

	public void increaseStock(Product product, Integer quantity, Double total) {
		Stock stock = null;
		for(Stock s: stocks) {
			if(s.getProduct().getName().equals(product.getName())) {
				stock = s;
			}
		}
		if(stock!=null) { //Product already in depot
			stock.setQuantity(stock.getQuantity()+quantity);
		}else { // New product to depot
			stock= new Stock(product,Type.EXTERNAL,quantity,1.0,2.0); //TODO prices should be random generated
		}
		this.allowance=this.allowance-total;
	}

	public void decreaseStock(Product product, Integer quantity, Double total) {
		Stock stock = null;
		for(Stock s: stocks) {
			if(s.getProduct().getName().equals(product.getName())) {
				stock = s;
			}
		}
		if(stock!=null) { //Product already in depot
			stock.setQuantity(stock.getQuantity()-quantity);
		}else { // Error
			throw new IllegalStateException("Stock for this product should exits");
		}
		this.allowance=this.allowance+total;
		
	}

}
