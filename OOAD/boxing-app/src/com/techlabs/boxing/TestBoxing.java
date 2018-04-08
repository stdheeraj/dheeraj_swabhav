package com.techlabs.boxing;

public class TestBoxing {
	
	public static void main(String[] args) {
		
		int x=10;
		System.out.println("x="+x);
		System.out.print("Boxing ->");
		Integer x1=new Integer(x);
		Integer x2=Integer.valueOf(x);
		Integer x3=x;                  //Autoboxing
		System.out.println("x1="+x1+", x2="+x2+", x3="+x3);
		System.out.println("-----------------------");
		
		Integer y1=new Integer(10);
		Integer y2=Integer.valueOf(20);
		Integer y3=30;
		System.out.println("y1="+y1+", y2="+y2+", y3="+y3);
		System.out.print("Unboxing ->");
		int i=y1;                //Auto unboxing
		int j=y2.intValue();
		int k=y3;                 //Auto unboxing
		System.out.println("i="+i+", j="+j+", k="+k);
		
		System.out.println("-----------------------");
		System.out.println("-----------------------");
		
		int a1=10,b1=10;
		System.out.print("Boxing -> ");
		add1(a1,b1);
		
		Integer a2=new Integer(10);
		Integer b2=new Integer(10);
		System.out.print("\nUnboxing -> ");;
		add2(a2,b2);

	}

	private static void add1(Integer a1, Integer b1) {
		System.out.print("a1 + b1 = "+(a1+b1));
	}
	
	private static void add2(int a2, int b2) {
		System.out.print("a2 + b2 = "+(a2+b2));
	}

}
