package com.techlabs.AccountInheritance;

public class CurrentAccount extends Account {
	public CurrentAccount(int accountno, String name, double balance) {
		super(accountno, name, balance);
	}

	@Override
	public void withdraw(int amt) {
		this.balance = this.balance - amt;
		System.out.println("Withdraw success");
	}
}