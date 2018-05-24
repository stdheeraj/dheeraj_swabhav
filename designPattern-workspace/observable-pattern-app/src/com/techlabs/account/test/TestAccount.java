package com.techlabs.account.test;

import com.techlabs.account.Account;
import com.techlabs.account.EMailListener;
import com.techlabs.account.IAccountListener;
import com.techlabs.account.SMSListener;

public class TestAccount {

	public static void main(String[] args) {
		
		Account acc1=new Account(101, "Dheeraj", 10000);
		
		IAccountListener sms=new SMSListener();
		IAccountListener email=new EMailListener();
		
		acc1.addListener(sms);
		acc1.addListener(email);
		
		acc1.deposit(15000);
		
	}

}
