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
			
			Depot depot = new Depot();
			int a = depot.getTypeN();
			System.out.println(a);
			
			int b = depot.getTypeX();
			System.out.println(b);
			
			int c = depot.getCashInitial();
			System.out.print(c);


			
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		init();

	}
	
	 

}
