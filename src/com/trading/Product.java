package com.trading;

public class Product {

	private String name;
	
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


	public Company getProducer() {
		return producer;
	}

	public void setProducer(Company producer) {
		this.producer = producer;
	}
	
	public String toString() {
		return "PRODUCT: "  + getName()+
				"\n";
	}

}
