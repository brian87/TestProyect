package com.trading;

import java.util.Date;

public class Transaccion {
	private DepotProduct depotProduct;
	private Depot buyerDepot;
	private Depot sellerDepot;
	private Integer quantity;
	private Double total;
	private Date date;

	public DepotProduct getDepotProduct() {
		return depotProduct;
	}

	public void setDepotProduct(DepotProduct depotProduct) {
		this.depotProduct = depotProduct;
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

}
