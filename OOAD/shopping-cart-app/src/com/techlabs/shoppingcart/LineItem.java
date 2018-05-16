package com.techlabs.shoppingcart;

public class LineItem {
	
	private Product product;
	private int quantity;
	
	public LineItem(Product product, int quantity) {
		this.product=product;
		setQuantity(quantity);
	}
	
	public Product getProduct() {
		return product;
	}
	
	public int getQuantity(){
		return quantity;
	}


	public void setQuantity(int quantity){
			this.quantity=quantity;
	}
	
	public double calTotalCost(){
		return ( product.productFinalCost()*quantity );
	}

	public String toString(){
		return ("\n\tQuantity: "+this.quantity+"\n\tProduct Details: "+this.product.toString());
	}
	
}
