package com.trading;

public class Product {

	private String name;
	private String type;
	private Company producer;

	public Product(String name) {
		this.name=name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Company getProducer() {
		return producer;
	}

	public void setProducer(Company producer) {
		this.producer = producer;
	}
	
	public String toString() {
		return "PRODUCT: "  + getName();
	}

}
