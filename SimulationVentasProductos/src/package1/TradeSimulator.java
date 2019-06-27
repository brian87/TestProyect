package package1;

import java.awt.List;
import java.util.ArrayList;

public class TradeSimulator {
	
	static ArrayList<Company> companies = new ArrayList<Company>();
	
	private static void init() {
		 initCompanies();
		 
		 
	 }

	private static void initCompanies() {
			Company BigA = new Company("A");
			Company BigB = new Company("B");
			companies.add(BigA);
			
			companies.add(BigB);
			
			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		init();

	}
	
	 

}
