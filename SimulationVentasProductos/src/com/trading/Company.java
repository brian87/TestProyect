package com.trading;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String name;
	private int MAX_NO_DEPOTS = 50;
	List<Depot> depots = new ArrayList<Depot>();

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
		depots.add(depot);
	}

}
