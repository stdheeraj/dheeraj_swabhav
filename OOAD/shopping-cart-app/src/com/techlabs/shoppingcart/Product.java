package com.techlabs.shoppingcart;

public class Product {
	
	private int id;
	private String name;
	private double cost;
	private float discount;
	
	public Product(int id, String name, double cost, float discount){
		this.id=id;
		this.name=name;
		this.cost=cost;
		this.discount=discount;
	}
	
	public int getId() {
		return id;
	}

	public double productFinalCost(){
		return (this.cost-this.discount*this.cost);
	}
	
	public String toString(){
		return ("\n\tProduct ID: "+this.id+"\n\tProduct Name: "+this.name+"\n\tProduct Cost: "+this.cost+"\n\tDiscount: "+(this.discount*100)+"%");
	}

}
