package package1;

import java.awt.List;
import java.util.ArrayList;

public class Company {
	 private String name;
	 private int MAX_NO_DEPOTS =50;
	 ArrayList<Depot> depots = new ArrayList<Depot>();
	 
	public Company(String _name) {
		this.name = _name;
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addDepot(Depot depot) {
		
	}
	public void addCadenaDepot() {
		for(int i =0; i < MAX_NO_DEPOTS; i++) {
			Depot depot = new Depot();
			addDepot(depot);
			
		}
	}
}
