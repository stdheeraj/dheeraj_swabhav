package com.techlabs.account;

public class Account {
	private final int accountno;
	private final String name;
	protected double balance;

	public Account(int accountno, String name, double balance) {
		this.accountno = accountno;
		this.name = name;
		this.setBalance(balance);
	}

	public void withdraw(int amt){
		if (this.balance - amt < 0)
			throw new InsufficientFundException(this);
		
		this.balance = this.balance - amt;
		System.out.println("Withdraw success");
	}

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