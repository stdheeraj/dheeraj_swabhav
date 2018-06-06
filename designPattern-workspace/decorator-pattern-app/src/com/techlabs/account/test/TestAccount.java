package com.techlabs.account.test;

import com.techlabs.account.Account;
import com.techlabs.account.IAccount;
import com.techlabs.account.LogDecorator;

public class TestAccount {

	public static void main(String[] args) {
		
		Account acc = new Account(101, "Dheeraj", 10000);
		
		IAccount acc1 = new LogDecorator(acc);
		
		acc1.deposit(500);
		
		System.out.println("Balance in Account : "+acc.getBalance()+"$");
		System.out.println("Balance in Log Decorator : "+acc1.getBalance()+"$");

	}

}
