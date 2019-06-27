package package1;

public class Depot{
	private int priceProduct;
	private int priceDelivery;
	
	public int getPriceProduct() {
		priceProduct = (int)(Math.random()*10+1);
		return priceProduct;
	}
	public void setPriceProduct(int priceProduct) {
		this.priceProduct = priceProduct;
	}
	public int getPriceDelivery() {
		priceProduct = (int)(Math.random()*10+1);
		return priceDelivery;
	}
	public void setPriceDelivery(int priceDelivery) {
		this.priceDelivery = priceDelivery;
	}

}
