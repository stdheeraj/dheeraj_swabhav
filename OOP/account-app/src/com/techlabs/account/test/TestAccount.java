package com.techlabs.account.test;

import com.techlabs.account.Account;

public class TestAccount {
	
	public static void main(String args[]) {
		
		Account acc1=new Account(101, "Dheeraj", 900.0);
		System.out.println("Account Holder : "+acc1.getAccHolder());
		//printDetails(acc1);
		Account acc2=new Account(102, "Prasad");
		System.out.println("Account Holder : "+acc2.getAccHolder());
		
		System.out.println("Head Count of A/C holders : "+Account.headCount());
		//printDetails(acc2);
		
		/*
		System.out.println("--- Deposit in acc2 ---");
		acc2.depositAmount(500.0);
		printDetails(acc2);
		
		System.out.println("--- Withdraw from acc1 ---");
		acc1.withdrawAmount(600.0);
		printDetails(acc1);
		*/
		
		System.out.println("Rich Person is "+acc2.whoIsRich(acc1).getName());
		
		
	}
	
	private static void printDetails(Account acc) {
		System.out.print("A/c No : "+acc.getAccount());
		System.out.print(", Name : "+acc.getName());
		System.out.println(", Balance : "+acc.getBalance());
	}

}
