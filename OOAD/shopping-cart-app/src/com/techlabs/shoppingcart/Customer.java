package com.techlabs.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String name;
	private List<Order> orders;
	
	public Customer(String name) {
		this.name=name;
		this.orders=new ArrayList<Order>();
	}

	public void addOrder(Order order){
		this.orders.add(order);
	}
	
	public double totalCost(){
		double totalcost=0;
		for (Order order : orders) {
			totalcost+=order.checkAtCost();
		}
		return totalcost;
	}
	
	public String toString(){
		return ("Name: "+this.name+"\nOrder Details ->"+this.orders.toString());
	}
	
}
