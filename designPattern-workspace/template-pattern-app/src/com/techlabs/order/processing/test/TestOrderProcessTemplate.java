package com.techlabs.order.processing.test;

import com.techlabs.order.processing.OnlineOrder;
import com.techlabs.order.processing.OrderProcessTemplate;
import com.techlabs.order.processing.StoreOrder;

public class TestOrderProcessTemplate {

	public static void main(String[] args) {
		
		OrderProcessTemplate onlineOrder = new OnlineOrder();
		onlineOrder.processOrder(true);
		
		System.out.println();
		OrderProcessTemplate storeOrder = new StoreOrder();
		storeOrder.processOrder(false);
	}

}
