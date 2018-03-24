package com.techlabs.AccountInheritance;

public class SavingAccount extends Account {
	public SavingAccount(int accountno, String name, double balance) {
		super(accountno, name, balance);
	}

	@Override
	public void withdraw(int amount) {
		if (this.balance - amount < 0)
			System.out.println("Withdraw denied");
		else {
			this.balance = this.balance - amount;
			System.out.println("Withdraw success");
		}
	}
}