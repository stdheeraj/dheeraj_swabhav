package com.techlabs.basic;

public class SplitTest {
	
	public static void main(String args[]){ 
		
		String s1="www.swabhavtechlabs.com?developer=Prashad";
		
		System.out.println("Domain is "+s1.split("\\.")[1]);
		System.out.print("Developer is "+s1.split("\\=")[1]);
	}

}