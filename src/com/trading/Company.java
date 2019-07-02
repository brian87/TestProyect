package com.trading;

import java.util.ArrayList;
import java.util.List;

public class Company {
	private String name;
	private int MAX_NO_DEPOTS = 50;
	private List<Depot> depots = new ArrayList<Depot>();

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
		depot.setCompany(this);
		depots.add(depot);
	}

	public List<Depot> getDepots() {
		return depots;
	}

	public void setDepots(List<Depot> depots) {
		this.depots = depots;
	}

	public int getMAX_NO_DEPOTS() {
		return MAX_NO_DEPOTS;
	}

	public void setMAX_NO_DEPOTS(int mAX_NO_DEPOTS) {
		MAX_NO_DEPOTS = mAX_NO_DEPOTS;
	}
	
	

}
