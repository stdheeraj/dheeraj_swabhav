package com.techlabs.account;

public class LogDecorator implements IAccount {

	private IAccount account;

	public LogDecorator(Account acc) {
		this.account = acc;
	}

	@Override
	public void deposit(double amt) {
		System.out.println("Balance before deposit : "+this.getBalance()+"$");
		
		this.account.deposit(amt);
		
		System.out.println("Balance after deposit : "+this.getBalance()+"$");
	}

	@Override
	public int getAccountNo() {
		return account.getAccountNo();
	}

	@Override
	public double getBalance() {
		return account.getBalance();
	}

	@Override
	public String getName() {
		return account.getName();
	}

}
