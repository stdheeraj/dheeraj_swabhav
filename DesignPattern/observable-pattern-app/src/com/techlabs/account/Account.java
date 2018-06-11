package com.techlabs.account;

import java.util.ArrayList;
import java.util.List;

public class Account {
	
	private int accNo;
	private String name;
	private double balance;
	private List<IAccountListener> listeners;
	
	public Account(int accNo, String name, double balance) {
		this.accNo = accNo;
		this.name = name;
		this.balance = balance;
		this.listeners = new ArrayList<IAccountListener>();
	}
	
	public void deposit(double amount){
		this.balance+=amount;
		this.notifyChange();
	}
	
	public void withdraw(double amount){
		this.balance-=amount;
		this.notifyChange();
	}
	
	private void notifyChange(){
		for (IAccountListener listener : this.listeners) {
			System.out.println("--------------------------------------------------");
			listener.balanceChanged(this);
		}
	}
	
	public int getAccNo() {
		return accNo;
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	public void addListener(IAccountListener listener){
		this.listeners.add(listener);
	}
	

}
