package com.techlabs.account;

public interface IAccount {
	
	public void deposit(double amt);
	public int getAccountNo();
	public double getBalance();
	public String getName();

}
