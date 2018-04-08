package com.techlabs.bug;

public class TestRunTimeStackTrace {
	
	public static void main(String[] args){
		try {
			m1();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("End of main");
	}

	private static void m1() {
		System.out.println("Inside M1");
		m2();
	}

	private static void m2() {
		System.out.println("Inside M2");
		m3();
	}

	private static void m3() throws RuntimeException {
		System.out.println("Inside M3");
		throw new RuntimeException("M3 generates exception");
	}

}
