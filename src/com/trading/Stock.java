package com.trading;

public class Stock {
	private Depot depot;
	private Product product;
	private Integer quantity;
	private Double productPrice;
	private Double deliveryPrice;
	private Type type;
	public static enum Type {NATIVE,EXTERNAL};

	public Stock(Product product, Type type, Integer quantity, Double productPrice, Double deliveryPrice) {
		this.product=product;
		this.type = type;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.deliveryPrice = deliveryPrice;
	}

	public Depot getDepot() {
		return depot;
	}

	public void setDepot(Depot depot) {
		this.depot = depot;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Double getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(Double deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	
	public String toString(){
		return " -------------------------------------------------\n"+
			   "| Product:" + product.getName() + "\t\t" +
			   "| Type: " + type + " \t |" + "\n" + 
			   " -------------------------------------------------\n"+
			   "| Quantity \t: " + quantity + "  \t \t \t \t |"+"\n" +
			   "| ProductPrice \t: " + String.format("%.2f",productPrice) + "  \t \t \t |" + "\n" +
			   "| DeliveryPrice : " + String.format("%.2f",deliveryPrice)+ " \t \t \t \t |" + "\n"+
			   " -------------------------------------------------\n";  
		
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	

}
