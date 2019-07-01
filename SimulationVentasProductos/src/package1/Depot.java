package package1;

import java.util.ArrayList;

public class Depot{
	private String name;
	private Company company;
	ArrayList<Product> products = new ArrayList<Product>();
	
	public void addProduct(Product product) {
		 products.add(product);
		
	}
	public void addcadenaProduct() {
		
		for(int i =0; i < 50; i++) {
			Product product = new Product();
			addProduct(product);
			
		}
	}

}
