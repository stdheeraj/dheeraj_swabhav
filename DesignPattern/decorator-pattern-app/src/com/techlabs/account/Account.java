package com.techlabs.account;

public class Account implements IAccount {
	private final int accountno;
	private final String name;
	protected double balance;

	public Account(int accountno, String name, double balance) {
		this.accountno = accountno;
		this.name = name;
		this.setBalance(balance);
	}

	@Override
	public void deposit(double amt) {
		this.setBalance(this.getBalance() + amt);
	}

	@Override
	public int getAccountNo() {
		return accountno;
	}

	@Override
	public double getBalance() {
		return balance;
	}

	@Override
	public String getName() {
		return name;
	}

	private void setBalance(double balance) {
		this.balance = balance;
	}
}