package com.trading;

import java.util.ArrayList;
import java.util.List;

public class Depot {
	private String name;
	private Company company;
	private List<DepotProduct> products = new ArrayList<DepotProduct>();

	public void addProduct(DepotProduct depotProduct) {
		products.add(depotProduct);
	}

}
