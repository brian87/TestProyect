package com.trading;

public class Stock {
	private Depot depot;
	private Product product;
	private Double initialCashNativeDepot;
	private Double finalCashNativeDepot;
	private Integer nativeDepotNativeQuantity;
	private Integer nativeDepotExternalQuantity;
	private Double productPrice;
	private Double deliveryPrice;
	private Type type;


	private Depot externalDepot;
	private Product externalProduct;
	private Double initialCashExternalDepot;
	private Double finalCashExternalDepot;
	private Integer externalDepotNativeQuantity;
	private Integer externalDepotExternalQuantity;
	private Double externalProductPrice;
	private Double externalDeliveryPrice;
	private Type externalType;
	
	public Stock(Product product, Type type, Integer quantity, Double productPrice, Double deliveryPrice) {
		this.product=product;
		this.type = type;
		this.nativeDepotNativeQuantity = quantity;
		this.productPrice = productPrice;
		this.deliveryPrice = deliveryPrice;
	}
	
	public Stock(Product product, Type type,Double initialCashNativeDepot, Double finalCashNativeDepot,Integer nativeDepotNativeQuantity,Integer nativeDepotExternalQuantity, Double productPrice, Double deliveryPrice,
			Product externalProduct, Type externalType, Double initialCashExternalDepot, Double finalCashExternalDepot, Integer externalDepotNativeQuantity,Integer externalDepotExternalQuantity, Double externalProductPrice, Double externalDeliveryPrice) {
		this.product=product;
		this.type = type;
		this.initialCashNativeDepot=initialCashNativeDepot;
		this.initialCashExternalDepot=initialCashExternalDepot;
		this.finalCashNativeDepot=finalCashNativeDepot;
		this.finalCashExternalDepot=finalCashExternalDepot;
		this.nativeDepotNativeQuantity = nativeDepotNativeQuantity;
		this.nativeDepotExternalQuantity = nativeDepotExternalQuantity;
		this.productPrice = productPrice;
		this.deliveryPrice = deliveryPrice;
		this.externalProduct=externalProduct;
		this.externalType = externalType;
		this.externalProductPrice = externalProductPrice;
		this.externalDeliveryPrice = externalDeliveryPrice;
		this.externalDepotNativeQuantity = externalDepotNativeQuantity;
		this.externalDepotExternalQuantity = externalDepotExternalQuantity;
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
	
	public String toString2(){
		return " ---------------------------------\n"+
			   "| "+product + "\t |" +"\n"+
			   "| Type\t\t: " + type + " \t |" + "\n" + 
			   " ---------------------------------\n"+
			   "| Quantity \t: " + nativeDepotNativeQuantity + "  \t \t |"+"\n" +
			   "| ProductPrice \t: " + String.format("%.2f",productPrice) + "  \t |" + "\n" +
			   "| DeliveryPrice : " + String.format("%.2f",deliveryPrice)+ " \t \t |" + "\n"+
			   " ---------------------------------\n";  
		
	}

	public String toString(){
		return " ---------------------------------" + " -------------------------------\n"+
			   "| "+product + "\t | |" +externalProduct +"\t | \n"+
			   "| Type\t\t: " + type + " \t | |"+"Type\t: " + externalType+"\t | \n" + 
			   " ---------------------------------" + " -------------------------------\n"+
			   "| Quantity \t: " + nativeDepotNativeQuantity + "  \t \t | | Quantity\t : " + nativeDepotExternalQuantity + "  \t\t | \n"+
			   "| ProductPrice \t: " + String.format("%.2f",productPrice) + "  \t | |   \t\t\t\t |"+ "\n" +
			   "| DeliveryPrice : " + String.format("%.2f",deliveryPrice)+ " \t \t | |  \t\t\t\t |" +"\n"+
			   " ---------------------------------" + " --------------------------------\n";  
		
	}
	
	public Double getInitialCashNativeDepot() {
		return initialCashNativeDepot;
	}

	public void setInitialCashNativeDepot(Double initialCashNativeDepot) {
		this.initialCashNativeDepot = initialCashNativeDepot;
	}
	
	public Double getFinalCashNativeDepot() {
		return finalCashNativeDepot;
	}

	public void setFinalCashNativeDepot(Double finalCashNativeDepot) {
		this.finalCashNativeDepot = finalCashNativeDepot;
	}
	
	public Double getInitialCashExternalDepot() {
		return initialCashExternalDepot;
	}

	public void setInitialCashExternalDepot(Double initialCashExternalDepot) {
		this.initialCashExternalDepot = initialCashExternalDepot;
	}
	
	public Double getFinalCashExternalDepot() {
		return finalCashExternalDepot;
	}

	public void setFinalCashExternalDepot(Double finalCashExternalDepot) {
		this.finalCashExternalDepot = finalCashExternalDepot;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	public Integer getQuantity() {
		return nativeDepotNativeQuantity;
	}

	public void setQuantity(Integer quantity) {
		this.nativeDepotNativeQuantity = quantity;
	}

	public Integer getNativeDepotExternalQuantity() {
		return nativeDepotExternalQuantity;
	}

	public void setNativeDepotExternalQuantity(Integer nativeDepotExternalQuantity) {
		this.nativeDepotExternalQuantity = nativeDepotExternalQuantity;
	}
	
	public Integer getNativeDepotNativeQuantity() {
		return nativeDepotNativeQuantity;
	}

	public void setNativeDepotNativeQuantity(Integer nativeDepotNativeQuantity) {
		this.nativeDepotNativeQuantity = nativeDepotNativeQuantity;
	}
	
	public Integer getExternalDepotExternalQuantity() {
		return externalDepotExternalQuantity;
	}

	public void setExternalDepotExternalQuantity(Integer externalDepotExternalQuantity) {
		this.externalDepotExternalQuantity = externalDepotExternalQuantity;
	}
	
	public Integer getExternalDepotNativeQuantity() {
		return externalDepotNativeQuantity;
	}

	public void setExternalDepotNativeQuantity(Integer externalDepotNativeQuantity) {
		this.externalDepotNativeQuantity = externalDepotNativeQuantity;
	}
	
}