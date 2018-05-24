package com.techlabs.adaptor.test;

import com.techlabs.adaptor.SwabhavQ;

public class TestSwabhavQ {

	public static void main(String[] args) {
		
		SwabhavQ<Integer> q=new SwabhavQ<Integer>();
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		//q.enqueue("Hello");
		System.out.println("Count after adding elements : "+q.count());
		
		System.out.println("Deleting "+q.dequeue()+" from Swabhav Queue.");
		System.out.println("Count after deleting element : "+q.count());
		
		System.out.print("Elements in Swabhav Queue : ");
		for (int n : q) {
			System.out.print(n+"\t");
		}

	}

}
