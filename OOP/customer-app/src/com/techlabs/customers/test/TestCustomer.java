package com.techlabs.customers.test;

import com.techlabs.customers.Customer;

public class TestCustomer {
	
	public static void main(String args[]){
		
		Customer c1=new Customer("Dheeraj", "Chaurasia", 1000);
		System.out.println("CustomerID of 1st customer is "+c1.getId());
		
		Customer c2=new Customer("Prasad", "Patil", 5000);
		System.out.println("CustomerID of 2nd customer is "+c2.getId());
	}

}
