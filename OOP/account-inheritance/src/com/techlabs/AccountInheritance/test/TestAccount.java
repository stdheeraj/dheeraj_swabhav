package com.techlabs.AccountInheritance.test;

import com.techlabs.AccountInheritance.CurrentAccount;
import com.techlabs.AccountInheritance.SavingAccount;

public class TestAccount {
	
	public static void main(String[] args){
		
		System.out.println("Current A/C ->");
		CurrentAccount cac=new CurrentAccount(101, "dheeraj", 1000);
		
		cac.deposit(500);
		System.out.println("After deposit, amount in "+cac.getName()+"'s account is "+cac.getBalance()+"$.");
		
		cac.withdraw(2000);
		System.out.println("After withdraw, amount in "+cac.getName()+"'s account is "+cac.getBalance()+"$.");
		
		
		
		System.out.println("\nSaving A/C ->");
		SavingAccount sac=new SavingAccount(102, "dheeraj", 1000);
		
		sac.deposit(500);
		System.out.println("After deposit, amount in "+sac.getName()+"'s account is "+sac.getBalance()+"$.");
		
		sac.withdraw(2000);
		System.out.println("After withdraw, amount in "+sac.getName()+"'s account is "+sac.getBalance()+"$.");
		
	}

}
