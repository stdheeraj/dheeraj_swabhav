package com.techlabs.AccountInheritance;

public abstract class Account {
	private final int accountno;
	private final String name;
	protected double balance;

	public Account(int accountno, String name, double balance) {
		this.accountno = accountno;
		this.name = name;
		this.setBalance(balance);
	}

	public abstract void withdraw(int amt);

	public void deposit(double amt) {
		this.setBalance(this.getBalance() + amt);
	}

	public int getAccountNo() {
		return accountno;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	private void setBalance(double balance) {
		this.balance = balance;
	}
}