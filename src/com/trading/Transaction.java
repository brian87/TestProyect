package com.trading;

import java.util.Date;

public class Transaction {
	private Product product;
	private Depot buyerDepot;
	private Depot sellerDepot;
	private Integer quantity;
	private Integer externalQuantity;
	private Double costProduct;
	private Double costDelivery;
	private Double totalCost;
	
	public Transaction() {
		
	}

	public Transaction(Product product,Depot buyerDepot,Depot sellerDepot,Integer quantity, int externalQuantity,
			Double costProduct,Double costDelivery,Double totalCost) {
		this.product=product;
		this.buyerDepot=buyerDepot;
		this.sellerDepot=sellerDepot;
		this.quantity=quantity;
		this.externalQuantity=externalQuantity;
		this.costProduct=costProduct;
		this.costDelivery=costDelivery;
		this.totalCost=totalCost;	
	}
	
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
	
	public Integer getExternalQuantity() {
		return externalQuantity;
	}

	public void setExternalQuantity(Integer externalQuantity) {
		this.externalQuantity = externalQuantity;
	}


	public Double getCostProduct() {
		return costProduct;
	}

	public void setCostProduct(Double costProduct) {
		this.costProduct = costProduct;
	}

	public Double getCostDelivery() {
		return costDelivery;
	}

	public void setCostDelivery(Double costDelivery) {
		this.costDelivery = costDelivery;
	}
	
	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
	
	public String toString(){
		return 
		   " ----------------------------------------    ----------------------------------------------------------------\n"+
		   "| Transaction" + " \t \t \t \t |"+"  | Before transaction \t \t|"+" After transaction \t     |"+"\n" +
		   " ----------------------------------------    ----------------------------------------------------------------\n"+
		   "| Buyer Depot\t: " + buyerDepot.getCompany().getName() + " [" + buyerDepot.getName() + "]\t |  |" + buyerDepot.getCompany().getName() + " [" + buyerDepot.getName() + "]\t \t|" +  buyerDepot.getCompany().getName() + " [" + buyerDepot.getName() + "]\t     |\n" +
		   "| Seller Depot\t: " +  sellerDepot.getCompany().getName() + " [" + sellerDepot.getName() + "] \t" + " |  | Cash:"+String.format("%.2f",buyerDepot.getStock().get(0).getInitialCashNativeDepot())+"   \t \t\t| Cash:"+String.format("%.2f",(buyerDepot.getStock().get(0).getInitialCashNativeDepot()-(costProduct+costDelivery)*quantity))+"\t\t     |\n"+
		   "| Product\t: " + product.getName() + "\t \t |  | Native Products:"+buyerDepot.getStock().get(0).getQuantity()+"\t\t"+"| Native Products:"+(buyerDepot.getStock().get(0).getQuantity())+"\t     |\n"+
		   "| Quantity\t: " + quantity + "  \t \t \t |"+"  | External Products: "+buyerDepot.getStock().get(0).getNativeDepotExternalQuantity()+"\t\t| External Products: "+(buyerDepot.getStock().get(0).getNativeDepotExternalQuantity()+quantity)+"\t     |\n" +
		   "| Cost Product\t: " + String.format("%.2f",costProduct*quantity)+ "  \t\t |  |"+ sellerDepot.getCompany().getName() + " [" + sellerDepot.getName() + "] \t \t|" + sellerDepot.getCompany().getName() + " [" + sellerDepot.getName() + "] \t     |\n" +  
		   "| Cost Delivery : " + String.format("%.2f",costDelivery*quantity)+  "  \t\t |  | " + "Cash:"+String.format("%.2f",sellerDepot.getStock().get(0).getInitialCashNativeDepot())+ "          \t\t| Cash:"+String.format("%.2f",sellerDepot.getStock().get(0).getInitialCashNativeDepot()+((costProduct+costDelivery)*quantity))+"\t \t     |\n"+
		   "| Total Cost\t: " + String.format("%.2f",(costProduct+costDelivery)*quantity)+ "    \t\t |  |" +" Native Products:"+sellerDepot.getStock().get(0).getQuantity()+"\t\t"+"| Native Products:"+(sellerDepot.getStock().get(0).getQuantity()-quantity)+"\t     |\n"+	 
		   " ----------------------------------------    ----------------------------------------------------------------"; 
	}
}
