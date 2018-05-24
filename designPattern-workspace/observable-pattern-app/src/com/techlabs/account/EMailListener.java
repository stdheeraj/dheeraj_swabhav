package com.techlabs.account;

public class EMailListener implements IAccountListener {

	@Override
	public void balanceChanged(Account account) {
		System.out.println("Balance is changed.");
		System.out.println("Email is sent to "+account.getName()+"'s mobile having account number as "+account.getAccNo()+".");
		System.out.println("Current balance is "+account.getBalance()+"$.");
	}

}
