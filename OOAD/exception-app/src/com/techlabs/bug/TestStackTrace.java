package com.techlabs.bug;

public class TestStackTrace {
	
	public static void main(String[] args) throws Exception{
		m1();
		
		System.out.println("End of main");
	}

	private static void m1() throws Exception {
		System.out.println("Inside M1");
		m2();
	}

	private static void m2() throws Exception {
		System.out.println("Inside M2");
		m3();
	}

	private static void m3() throws Exception {
		System.out.println("Inside M3");
		throw new Exception("M3 generates exception");
	}

}
