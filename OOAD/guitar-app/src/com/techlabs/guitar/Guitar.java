package com.techlabs.guitar;

public class Guitar {
	
	private String serialNumber;
	private double price;
	private GuitarSpec spec;
	
	public Guitar(String serialNumber, double price, GuitarSpec spec){
		this.serialNumber=serialNumber;
		setPrice(price);
		this.spec=spec;

	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(Double price){
		this.price=price;
	}

	public GuitarSpec getSpec() {
		return spec;
	}
}
