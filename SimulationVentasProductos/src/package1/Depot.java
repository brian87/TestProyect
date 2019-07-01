package package1;

import java.util.ArrayList;

public class Depot{
	private String name;
	private Company company;
	private int typeN;
	private int typeX;
	private int cashInitial;
	
	ArrayList<Product> products = new ArrayList<Product>();
	
	
	public void addProduct(Product product) {
		 products.add(product);
		
	}
	
	public void addcadenaProduct() {
		
		for(int i =0; i < (getTypeN()+ getTypeX()) ; i++) {
			Product product = new Product();
			addProduct(product);
			
		}
	}
	
	public int getTypeN() {
		typeN =  (int)(Math.random()*(50-15+1)+15);
		return typeN;
	}
	
	public int getTypeX() {
		typeX =  (int)(Math.random()*(40-3+1)+3);
		return typeX;
	}
	
	public int getCashInitial() {
		cashInitial =  (int)(Math.random()*(100-50+1)+50);
		return cashInitial;
	}
}
