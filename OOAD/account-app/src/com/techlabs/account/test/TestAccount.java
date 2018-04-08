package com.techlabs.account.test;

import com.techlabs.account.Account;
import com.techlabs.account.InsufficientFundException;
public class TestAccount {
	
	public static void main(String[] args){

		Account ac=new Account(102, "Dheeraj", 1000);
		
		ac.deposit(500);
		System.out.println("After deposit, amount in "+ac.getName()+"'s account is "+ac.getBalance()+"$.\n");
		
		try{
		ac.withdraw(2000);
		} catch (InsufficientFundException ex){
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Amount in "+ac.getName()+"'s account is "+ac.getBalance()+"$.");

	}

}