package com.techlabs.rectangle.test;

import com.techlabs.rectangle.BorderStyleOption;
import com.techlabs.rectangle.Rectangle;

public class RectangleTest {
	public static void main(String[] args){
		
		Rectangle r1 = new Rectangle(10,20,BorderStyleOption.DOTTED);
		printDetails(r1);
		Rectangle r2 = new Rectangle(5,10);
		printDetails(r2);

	}
	
	private static void printDetails(Rectangle r){
		
	//	System.out.println("The width of rectangle is "+r.getWidth());
	//	System.out.println("The hieght of rectangle is "+r.getHieght());
		System.out.println("The area of rectangle is "+r.calcArea()+" having width "+r.getWidth()+" and hieght "+r.getHieght());
		System.out.println("Border style is "+r.getBorder());
	}

}
