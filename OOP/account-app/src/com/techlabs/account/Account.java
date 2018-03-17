package com.techlabs.account;

public class Account {
	
	private int account;
	private String name;
	private double balance;
	private static int count;
	
	public Account(int paccount, String pname, double pbalance) {
		this.account=paccount;
		this.name=pname;
		this.balance=pbalance;
		count++;
	}
	
	public Account(int paccount, String pname) {
		this(paccount, pname, 500.0);
	}
	
	public int getAccount(){
		return account;
	}
	
	public String getName(){
		return name;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void withdrawAmount(double amt) {
		if((balance-amt)>=500.0)
			this.balance-=amt;
		else
			System.out.println("You can't withdraw amount");
	}
	
	public void depositAmount(double amt) {
		this.balance+=amt;
	}
	
	public Account whoIsRich(Account acc) {
		if(this.balance<acc.balance)
			return acc;
		else
			return this;
	}
	
	public int getAccHolder() {
		return count;
	}
	
	public static int headCount() {
		return count;
	}
	
	

}
