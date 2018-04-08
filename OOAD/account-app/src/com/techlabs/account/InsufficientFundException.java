package com.techlabs.account;

public class InsufficientFundException extends RuntimeException {
	
	Account account;
	
	public InsufficientFundException(Account account) {
		//super(account.getName()+" does not have sufficient balance to withdraw");
		this.account=account;
	}
	
	@Override
	public String getMessage() {
		return account.getName()+" does not have sufficient balance to withdraw.";
	}

}
