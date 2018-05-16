package com.techlabs.shoppingcart;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
	
	private Date date;
	private List<LineItem> orderItems=new ArrayList<LineItem>();

	public Order(Date date){
		this.date=date;
	}

	public List<LineItem> getOrderItems() {
		return orderItems;
	}

	public void addToCart(LineItem li){
		for (LineItem lineItem : orderItems) {
			if(lineItem.getProduct().getId()==li.getProduct().getId()){
				lineItem.setQuantity(lineItem.getQuantity()+li.getQuantity());
				return;
			}
		}
		getOrderItems().add(li);
	}
	
	public double checkAtCost(){
		double totalcost=0;
		for (LineItem li : getOrderItems()) {
			totalcost+=li.calTotalCost();
		}
		return totalcost;
	}
	
	public String toString(){
		return ("\nDate: "+this.date+"\nOrdered Items: "+this.orderItems.toString());
	}

}
