package com.techlabs.rectangle.test;

import com.techlabs.rectangle.Rectangle;

public class TestRectangle {

	public static void main(String args[]) {

		Rectangle r1;
		r1 = new Rectangle();
		
		r1.setWidth(150);
		r1.setHieght(20);

		System.out.println("Area of rectangle " + r1.calculateArea());
		System.out.println("Width :" + r1.getWidth() + "\nHieght :" + r1.getHieght());
	}
}