package com.techlabs.shoppingcart.test;

import java.util.Calendar;
import com.techlabs.shoppingcart.Customer;
import com.techlabs.shoppingcart.LineItem;
import com.techlabs.shoppingcart.Order;
import com.techlabs.shoppingcart.Product;

public class TestShopOnline {
	
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();
	
		Product p=new Product(101, "Iphone 6s", 1150, 0.2f);
		Product p1=new Product(102, "Note 4", 170, 0.35f);
		
		calendar.set(2017, 11, 20);
		Order order=new Order(calendar.getTime());
		order.addToCart(new LineItem(p, 2));
		order.addToCart(new LineItem(p1, 1));
		order.addToCart(new LineItem(p, 5));
		
		Customer d=new Customer("Dheeraj");
		d.addOrder(order);
		printOrderHistory(d);
		
		
	}
	
	private static void printOrderHistory(Customer c) {
		System.out.println(c.toString());
		System.out.println("Total Cost of all Product = "+(int)c.totalCost()+" $");
	}
}
