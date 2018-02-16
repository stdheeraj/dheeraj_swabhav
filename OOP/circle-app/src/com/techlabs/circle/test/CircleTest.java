package com.techlabs.circle.test;

import com.techlabs.circle.Circle;

public class CircleTest {

	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle();

		c1.setColor("BLUE");

		printDetails(c1);
		printDetails(c2);

		/*
		 * Circle temp = c1; System.out.println(temp.getRadius());
		 * temp.setRadius(1); System.out.println(temp.getRadius());
		 * System.out.println(c1.getRadius());
		 * 
		 * printDetails(c1); printDetails(temp);
		 */
		
		//Anonymous object
		System.out.println(new Circle().calArea());
		printDetails(new Circle());
	}

	private static void printDetails(Circle c) {
		System.out.println("Area of circle of radius " + c.getRadius() + " is "
				+ c.calArea() + " having color " + c.getColor());

		System.out.println(" Hash code is " + c.hashCode());
	}
}
