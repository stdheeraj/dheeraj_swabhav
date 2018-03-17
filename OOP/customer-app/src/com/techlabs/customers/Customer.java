package com.techlabs.customers;

public class Customer {
	private static int id=100;
	private String fname;
	private String lname;
	private int moneyspent;
	
	public Customer(String pfname, String plname, int pmoneyspent) {
		this.id=generateId();
		this.fname=pfname;
		this.lname=plname;
		this.moneyspent=pmoneyspent;
	}
	
	private int generateId() {
		return id+1;
	}
	
	public int getId() {
		return this.id;
	}
	

}
