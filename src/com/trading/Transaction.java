package com.trading;

import java.util.Date;

public class Transaction {
	private Product product;
	private Depot buyerDepot;
	private Depot sellerDepot;
	private Integer quantity;
	private Double total = 0.0;
	private Date date;
	
	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Depot getBuyerDepot() {
		return buyerDepot;
	}

	public void setBuyerDepot(Depot buyerDepot) {
		this.buyerDepot = buyerDepot;
	}

	public Depot getSellerDepot() {
		return sellerDepot;
	}

	public void setSellerDepot(Depot sellerDepot) {
		this.sellerDepot = sellerDepot;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	public String toString(){
		return 
		   " -------------------------------------------------\n"+
		   "| Transaction" + " \t \t \t \t \t |\n" +
		   " -------------------------------------------------\n"+
		   "| Product \t: " + product.getName() + " \t \t \t |\n" +
		   "| Quantity \t: " + quantity + "  \t \t \t \t |"+"\n" +
		   "| Buyer Depot \t: " + buyerDepot.getCompany().getName() + " [" + buyerDepot.getName() + "] \t \t |" + "\n" +
		   "| Seller Depot \t: " +  sellerDepot.getCompany().getName() + " [" + sellerDepot.getName() + "] \t \t |" + "\n"+
		   "| Total \t: " + String.format("%.2f",total) + " \t \t \t |\n" +
		   " -------------------------------------------------\n"; 
	}
}
