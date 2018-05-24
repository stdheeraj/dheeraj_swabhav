package com.techlabs.account;

public class SMSListener implements IAccountListener {

	@Override
	public void balanceChanged(Account account) {
		System.out.println("Balance is changed.");
		System.out.println("SMS is sent to "+account.getName()+"'s mobile having account number as "+account.getAccNo()+".");
		System.out.println("Current balance is "+account.getBalance()+"$.");
	}

}
